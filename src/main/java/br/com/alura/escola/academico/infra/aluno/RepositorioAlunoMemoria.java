package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.repositorio.IRepositorioAluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RepositorioAlunoMemoria implements IRepositorioAluno {
 
    private List<Aluno> alunoList = new ArrayList<>();
    
    public RepositorioAlunoMemoria() {}
    
    @Override
    public void matricular(Aluno aluno) {
       alunoList.add(aluno);
    }
    
    @Override
    public Optional<Aluno> buscarPorCPF(CPF cpf) {
       return alunoList.stream().filter(aluno -> aluno.equalsCPF(cpf))
                       .findFirst();
    }
    
    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return Collections.unmodifiableList(alunoList);
    }
}