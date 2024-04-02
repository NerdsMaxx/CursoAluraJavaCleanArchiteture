package br.com.alura.escola.academico.dominio.indicacao;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class Indicacao {
    
    private Aluno indicante;
    private Aluno indicado;
    private LocalDateTime dataIndicacao;
    
    public Indicacao(Aluno indicante, Aluno indicado) {
        this.indicante = requireNonNull(indicante);
        this.indicado = requireNonNull(indicado);
        dataIndicacao = LocalDateTime.now();
    }
    
    public Aluno getIndicante() {
        return indicante;
    }
    
    public Aluno getIndicado() {
        return indicado;
    }
    
    public LocalDateTime getDataIndicacao() {
        return dataIndicacao;
    }
}