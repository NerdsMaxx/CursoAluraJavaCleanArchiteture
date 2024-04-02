package br.com.alura.escola.academico;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.fabrica.FabricaDeAluno;
import br.com.alura.escola.academico.infra.PostgresJDBC;
import br.com.alura.escola.academico.infra.aluno.RepositorioAlunoJDBC;

import java.util.Optional;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        PostgresJDBC.carregarDriver();
        RepositorioAlunoJDBC repositorioAlunoJDBC = RepositorioAlunoJDBC.criar(PostgresJDBC.getConexao());
        
        repositorioAlunoJDBC.limparTodos();
        
        Aluno aluno1 = FabricaDeAluno
                .instancia()
                .comNomeCPFEmail("Guilherme", "001.000.000-00", "exemplo1@gmail.com")
                .comTelefone("62", "99999-9999")
                .criar();

        repositorioAlunoJDBC.matricular(aluno1);
        
        Aluno alunoEncontrado = repositorioAlunoJDBC.obterPorCPF(new CPF("001.000.000-00"));
        out.println(alunoEncontrado);
        
        Optional<Aluno> alunoOpt = repositorioAlunoJDBC.buscarPorCPF(new CPF("000.000.000-00"));
        out.println(alunoOpt);
        
        Aluno aluno2 = FabricaDeAluno
                .instancia()
                .comNomeCPFEmail("Watyson","002.000.000-00", "exemplo2@gmail.com")
                .comTelefone("62", "88888-8888")
                .comTelefone("01", "77777-7777")
                .criar();
        
        repositorioAlunoJDBC.matricular(aluno2);
        
       repositorioAlunoJDBC.listarTodosAlunosMatriculados()
                           .forEach(out::println);
    }
}