package br.com.alura.escola.academico.dominio.aluno.evento;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Map;

public class AlunoMatriculado implements Evento {
    
    private CPF cpfDoAluno;
    private LocalDateTime momento;
    
    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }
    
    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
    
    @Override
    public LocalDateTime momento() {
        return this.momento;
    }
    
    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }
    
    @Override
    public Map<String,Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }
}