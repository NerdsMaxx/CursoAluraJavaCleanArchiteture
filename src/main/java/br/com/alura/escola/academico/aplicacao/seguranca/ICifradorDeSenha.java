package br.com.alura.escola.academico.aplicacao.seguranca;

public interface ICifradorDeSenha {
    
    String cifrarSenha(String senha);
    
    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}