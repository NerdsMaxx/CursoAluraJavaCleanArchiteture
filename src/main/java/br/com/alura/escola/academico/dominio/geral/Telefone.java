package br.com.alura.escola.academico.dominio.geral;

import br.com.alura.escola.academico.dominio.geral.excecao.TelefoneInvalido;

import static java.util.Objects.requireNonNull;

public record Telefone(String ddd, String numero) {
    
    private static final String REGEX_DDD = "^\\d{2}$";
    private static final String REGEX_NUMERO = "^\\d{4,5}-\\d{4}";
    
    public Telefone(String ddd, String numero) {
        requireNonNull(ddd); requireNonNull(numero);
        
        if(! ddd.matches(REGEX_DDD) || ! numero.matches(REGEX_NUMERO)) {
            throw new TelefoneInvalido();
        }
        
        this.ddd = ddd;
        this.numero = numero;
    }
}