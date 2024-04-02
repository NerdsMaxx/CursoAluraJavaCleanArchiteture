package br.com.alura.escola.academico.dominio.geral.excecao;

public class TelefoneInvalido extends RuntimeException {
    
    public TelefoneInvalido() {
        super("Telefone é inválido!");
    }
}