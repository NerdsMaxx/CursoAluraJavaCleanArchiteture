package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.dominio.geral.Telefone;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.fabrica.FabricaDeAluno;
import br.com.alura.escola.academico.dominio.aluno.fabrica.IFabricaAluno;
import br.com.alura.escola.academico.dominio.aluno.repositorio.IRepositorioAluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

public class RepositorioAlunoJDBC  implements IRepositorioAluno {
    
    private static RepositorioAlunoJDBC instancia;
    
    private Connection conexao;
    
    private RepositorioAlunoJDBC(Connection conexao) {
        this.conexao = conexao;
    }
    
    public static RepositorioAlunoJDBC criar(final Connection conexao) {
        if(isNull(instancia)) {
            instancia = new RepositorioAlunoJDBC(conexao);
        }
        
        return instancia;
    }
    
    public static RepositorioAlunoJDBC getInstancia() {
        if(isNull(instancia)) {
            throw new IllegalStateException("Deve ser criado instancia antes de obter!");
        }
        
        return instancia;
    }
    
    @Override
    public void matricular(Aluno aluno) {
        try {
            String alunoSql = "INSERT INTO aluno VALUES(?, ?, ?)";
            PreparedStatement alunoPs = conexao.prepareStatement(alunoSql);
            
            alunoPs.setString(1, aluno.getCpf().numero());
            alunoPs.setString(2, aluno.getNome());
            alunoPs.setString(3, aluno.getEmail().endereco());
            alunoPs.execute();
            
            String telefoneSql = "INSERT INTO telefone VALUES(?, ?, ?)";
            PreparedStatement telefonePs = conexao.prepareStatement(telefoneSql);
            
            for(Telefone tel : aluno.getTelefoneList()) {
                telefonePs.setString(1, aluno.getCpf().numero());
                telefonePs.setString(2, tel.ddd());
                telefonePs.setString(3, tel.numero());
                telefonePs.execute();
            }
            
            conexao.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Optional<Aluno> buscarPorCPF(CPF cpf) {
        try {
            String alunoSql = "SELECT al.* FROM aluno al WHERE al.cpf = ?";
            PreparedStatement alunoPs = conexao.prepareStatement(alunoSql);
            alunoPs.setString(1, cpf.numero());
            alunoPs.execute();
            
            ResultSet alunoRs = alunoPs.getResultSet();
            
            if(! alunoRs.next()) {
                return Optional.empty();
            }
            
            IFabricaAluno.IFabricaFinal fabricaAluno = FabricaDeAluno
                    .instancia()
                    .comNomeCPFEmail(alunoRs.getString("nome"),
                                     alunoRs.getString("cpf"),
                                     alunoRs.getString("email"));
            
            String telefoneSql = "SELECT tel.* FROM telefone tel WHERE tel.cpf = ?";
            PreparedStatement telefonePs = conexao.prepareStatement(telefoneSql);
            telefonePs.setString(1, cpf.numero());
            telefonePs.execute();
            
            ResultSet telefoneRs = telefonePs.getResultSet();
            
            while(telefoneRs.next()) {
                fabricaAluno.comTelefone(telefoneRs.getString("ddd"),
                                         telefoneRs.getString("numero"));
            }
            
           return Optional.of(fabricaAluno.criar());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String listarTodoAlunoSql = "SELECT al.* FROM aluno al";
            PreparedStatement alunoPs = conexao.prepareStatement(listarTodoAlunoSql);
            alunoPs.execute();
            
            ResultSet alunoRs = alunoPs.getResultSet();
            boolean alunoPresente = alunoRs.next();
            
            if(! alunoPresente) {
                return List.of();
            }
            
            List<Aluno> alunoList = new ArrayList<>(alunoRs.getFetchSize());
            
            while(alunoPresente) {
                IFabricaAluno.IFabricaFinal fabricaAluno = FabricaDeAluno
                        .instancia()
                        .comNomeCPFEmail(alunoRs.getString("nome"),
                                         alunoRs.getString("cpf"),
                                         alunoRs.getString("email"));
                
                String listarTelefonePorCPFSql = "SELECT tel.* FROM telefone tel WHERE tel.cpf = ?";
                PreparedStatement telefonePs = conexao.prepareStatement(listarTelefonePorCPFSql);
                telefonePs.setString(1, alunoRs.getString("cpf"));
                telefonePs.execute();
                
                ResultSet telefoneRs = telefonePs.getResultSet();
                boolean telefonePresente = telefoneRs.next();
                
                while(telefonePresente) {
                    fabricaAluno.comTelefone(telefoneRs.getString("ddd"), telefoneRs.getString("numero"));
                    telefonePresente = telefoneRs.next();
                }
                
                alunoList.add(fabricaAluno.criar());
                
                alunoPresente = alunoRs.next();
            }
            
            return alunoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void limparTodos() {
        try {
            String sql = "DELETE FROM telefone; DELETE FROM aluno";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
            
            conexao.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}