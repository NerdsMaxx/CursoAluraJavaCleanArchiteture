package br.com.alura.escola.academico.dominio.geral;

import br.com.alura.escola.academico.dominio.geral.excecao.EmailInvalido;

import static java.util.Objects.requireNonNull;

//Value Object - VO
public record Email(String endereco) {
    
    private static final String REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    
    public Email(String endereco) {
        requireNonNull(endereco);
        
        if (! endereco.matches(REGEX)) {
            throw new EmailInvalido();
        }
        
        this.endereco = endereco;
    }
}

//public class Email {
//
//    private static String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
//
//    private String endereco;
//
//    public Email(String endereco) {
//        requireNonNull(endereco);
//
//        if (! endereco.matches(regex)) {
//            throw new IllegalArgumentException("E-mail inválido!");
//        }
//
//        this.endereco = endereco;
//    }
//
//    public String getEmail() {
//        return endereco;
//    }
//}