package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.cpf.CPF;

import static java.util.Objects.requireNonNull;

public class Selo {
    
    private CPF cpfDoAluno;
    private String nome;
    
    public Selo(CPF cpfDoAluno, String nome) {
        this.cpfDoAluno = requireNonNull(cpfDoAluno);
        this.nome = requireNonNull(nome);
    }
    
    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
    
    public String getNome() {
        return nome;
    }
}