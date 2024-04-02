package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.ouvinte.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.repositorio.IRepositorioAluno;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.infra.aluno.RepositorioAlunoMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatricularAlunoTest {
    
    @Test
    void alunoDeveriaSerPersistido() {
        IRepositorioAluno repositorioAluno = new RepositorioAlunoMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        
        MatricularAluno useCase = new MatricularAluno(repositorioAluno, publicador);
        
        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Guilherme", "000.000.000-11", "henr@gmail.com");
        useCase.executa(dados);
        
        Aluno encontrado = repositorioAluno.obterPorCPF(new CPF("000.000.000-11"));
        
        assertEquals("Guilherme", encontrado.getNome());
        assertEquals(new CPF("000.000.000-11"), encontrado.getCpf());
        assertEquals("henr@gmail.com", encontrado.getEmail().endereco());
    }
}