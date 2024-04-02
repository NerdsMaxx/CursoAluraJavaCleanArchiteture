package br.com.alura.escola.academico.dominio;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.shared.dominio.cpf.excecao.CPFInvalido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CpfTeste {
    
    @Test
    void naoDeveriaCriarCpfComNumeroInvalido() {
        assertThrows(NullPointerException.class, () -> new CPF(null));
        assertThrows(CPFInvalido.class, () -> new CPF(""));
        assertThrows(CPFInvalido.class, () -> new CPF("123123123123"));
        assertThrows(CPFInvalido.class, () -> new CPF("123.123.123.123"));
        assertThrows(CPFInvalido.class, () -> new CPF("123.123.12312"));
        assertThrows(CPFInvalido.class, () -> new CPF("123123.123.12"));
        assertThrows(CPFInvalido.class, () -> new CPF("123123123aa"));
        assertThrows(CPFInvalido.class, () -> new CPF("abcdefghirjakcn"));
        assertThrows(CPFInvalido.class, () -> new CPF("´[[]]dsa]dsa]dsa]"));
    }
    
    @Test
    void deveriaCriarCpfComNumeroValido() {
        assertDoesNotThrow(() -> new CPF("123.123.123-12"));
    }
    
    @Test
    void doisCpfsComNumerosIguaisDevemSerIguais() {
        final CPF cpf1 = new CPF("123.123.123-12");
        final CPF cpf2 = new CPF("123.123.123-12");
        
        assertEquals(cpf1, cpf2);
    }
    
    @Test
    void doisCpfsComNumerosDiferentesDevemSerDiferentes() {
        final CPF cpf1 = new CPF("123.123.123-12");
        final CPF cpf2 = new CPF("123.123.123-88");
        
        assertNotEquals(cpf1, cpf2);
    }
}