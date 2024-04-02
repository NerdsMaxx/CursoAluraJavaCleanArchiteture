package br.com.alura.escola.academico.dominio;

import br.com.alura.escola.academico.dominio.geral.Telefone;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelefoneTeste {
    
    @Test
    void naoDeveriaCriarTelefoneComDDDInvalido() {
        assertThrows(NullPointerException.class, () -> new Telefone(null, "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("a", "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("aa", "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("a1", "12312-3123"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1a", "12312-3123"));
    }
    
    @Test
    void naoDeveriaCriarTelefoneComNumeroInvalido() {
        assertThrows(NullPointerException.class, () -> new Telefone("62", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("62", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("62", "123aaa"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("62", "123456"));
    }
    
    @Test
    void deveriaCriarTelefoneComDDDENumeroValido() {
        assertDoesNotThrow(() -> new Telefone("62", "1231-2312"));
        assertDoesNotThrow(() -> new Telefone("62", "12312-1231"));
    }
    
    @Test
    void doisTelefonesComDDDENumeroIguaisDevemSerIguais() {
        final Telefone telefone1 = new Telefone("62", "1231-2312");
        final Telefone telefone2 = new Telefone("62", "1231-2312");
        
        assertEquals(telefone1, telefone2);
    }
    
    @Test
    void doisTelefonesComDDDENumeroDiferentesDevemSerDiferentes() {
        final Telefone telefone1 = new Telefone("62", "1231-2312");
        final Telefone telefone2 = new Telefone("62", "1231-2388");
        
        assertNotEquals(telefone1, telefone2);
    }
}