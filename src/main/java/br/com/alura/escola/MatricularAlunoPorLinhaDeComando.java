package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.ouvinte.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.repositorio.IRepositorioAluno;
import br.com.alura.escola.academico.infra.aluno.RepositorioAlunoMemoria;
import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

import static java.util.Objects.requireNonNull;

public class MatricularAlunoPorLinhaDeComando {
    
    private MatricularAluno matricularAluno;
    
    public MatricularAlunoPorLinhaDeComando(MatricularAluno matricularAluno) {
        this.matricularAluno = requireNonNull(matricularAluno);
    }
    
    public void matricular() {
        IRepositorioAluno repositorioAluno = new RepositorioAlunoMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        
        MatricularAluno useCase = new MatricularAluno(repositorioAluno, publicador);
        
        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Guilherme", "000.000.000-11", "henr@gmail.com");
        useCase.executa(dados);
        
        Aluno encontrado = repositorioAluno.obterPorCPF(new CPF("000.000.000-11"));
    }
}