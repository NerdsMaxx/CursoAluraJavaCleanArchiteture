package br.com.alura.escola.shared.dominio.cpf.excecao;

public class CPFInvalido extends RuntimeException {

    public CPFInvalido() {
        super("CPF Inválido! Deve estar no formate 999.999.999-99!");
    }
}