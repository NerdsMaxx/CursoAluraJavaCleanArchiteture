package br.com.alura.escola.academico.dominio.geral.excecao;

public class EmailInvalido extends RuntimeException {
    public EmailInvalido() {
        super("Email inválido!");
    }
}