package br.com.alura.escola.shared.dominio.cpf;

import br.com.alura.escola.shared.dominio.cpf.excecao.CPFInvalido;

import static java.util.Objects.requireNonNull;

//Value Object - VO
public record CPF(String numero) {
    
    private static final String REGEX = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$";
    
    public CPF(final String numero) {
        requireNonNull(numero);
        
        if (! numero.matches(REGEX)) {
            throw new CPFInvalido();
        }
        
        this.numero = numero;
    }
}

//public class CPF {
//
//    private static String regex = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$";
//
//    private String numero;
//
//    public CPF(String numero) {
//        requireNonNull(numero);
//
//        if(! numero.matches(regex)) {
//            throw new IllegalArgumentException("CPF não válido. Deve conter somente 11 dígitos!");
//        }
//
//        this.numero = numero;
//    }
//
//    public String getCpf() {
//        return numero;
//    }
//}