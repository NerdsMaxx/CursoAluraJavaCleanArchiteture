package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.evento.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.repositorio.IRepositorioAluno;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

import static java.util.Objects.requireNonNull;

public class MatricularAluno {
    
    private IRepositorioAluno repositorioAluno;
    private PublicadorDeEventos publicador;
    
    public MatricularAluno(IRepositorioAluno repositorioAluno, PublicadorDeEventos publicador) {
        this.repositorioAluno = requireNonNull(repositorioAluno);
        this.publicador = requireNonNull(publicador);
    }
    
    public void executa(MatricularAlunoDto matricularAlunoDto) {
        Aluno aluno = matricularAlunoDto.criarAluno();
        repositorioAluno.matricular(aluno);
        
        AlunoMatriculado alunoMatriculado = new AlunoMatriculado(aluno.getCpf());
        publicador.publicar(alunoMatriculado);
    }
}