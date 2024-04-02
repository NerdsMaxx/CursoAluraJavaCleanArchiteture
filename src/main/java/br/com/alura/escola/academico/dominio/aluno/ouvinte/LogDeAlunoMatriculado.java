package br.com.alura.escola.academico.dominio.aluno.ouvinte;

import br.com.alura.escola.academico.dominio.aluno.evento.AlunoMatriculado;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

public class LogDeAlunoMatriculado extends Ouvinte {
    
    @Override
    public void reageAo(Evento evento) {
        AlunoMatriculado alunoMatriculado = (AlunoMatriculado) evento;
        
        String momento = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                          .format(evento.momento());
        
        out.println("Aluno com CPF " + alunoMatriculado.getCpfDoAluno().numero()
                    + " em " + momento + "!");
    }
    
    @Override
    public boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoDeEvento.ALUNO_MATRICULADO);
    }
}