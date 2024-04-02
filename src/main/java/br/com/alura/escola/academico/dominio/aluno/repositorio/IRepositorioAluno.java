package br.com.alura.escola.academico.dominio.aluno.repositorio;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.excecao.AlunoNaoEncontrado;

import java.util.List;
import java.util.Optional;

public interface IRepositorioAluno {
    
    void matricular(Aluno aluno);
    
    Optional<Aluno> buscarPorCPF(CPF cpf);
    
    default Aluno obterPorCPF(CPF cpf) {
        return buscarPorCPF(cpf)
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    List<Aluno> listarTodosAlunosMatriculados();
}