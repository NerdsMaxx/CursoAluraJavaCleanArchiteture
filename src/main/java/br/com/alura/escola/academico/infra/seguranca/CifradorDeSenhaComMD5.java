package br.com.alura.escola.academico.infra.seguranca;

import br.com.alura.escola.academico.aplicacao.seguranca.ICifradorDeSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDeSenhaComMD5 implements ICifradorDeSenha {
    
    //IMPLEMENTAÇÃO SIMPLES, APENAS PARA APRENDER, NÃO É PARA USAR NA PRODUÇÃO FINAL
    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro ao gerar hash da senha");
        }
    }
    
    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }
}