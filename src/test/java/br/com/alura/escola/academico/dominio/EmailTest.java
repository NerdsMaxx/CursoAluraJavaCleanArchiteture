package br.com.alura.escola.academico.dominio;

import br.com.alura.escola.academico.dominio.geral.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    
    @Test
    void naoDeveriaCriarEmailComEnderecoInvalido() {
        assertThrows(NullPointerException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("falhar"));
    }
    
    @Test
    void deveriaCriarEmailComEnderecoValido() {
        assertDoesNotThrow(() -> new Email("guinas@gmail.com"));
        assertDoesNotThrow(() -> new Email("a123@gmail.com"));
        assertDoesNotThrow(() -> new Email("a123ola@gmail.com"));
    }
    
    @Test
    void doisEmailsComEnderecosIguaisDevemSerIguais() {
        final Email email1 = new Email("guinas@gmail.com");
        final Email email2 = new Email("guinas@gmail.com");
        
        assertEquals(email1, email2);
    }
    
    @Test
    void doisEmailsComEnderecosDiferentesDevemSerDiferentes() {
        final Email email1 = new Email("guinas@gmail.com");
        final Email email2 = new Email("guinas123456789@gmail.com");
        
        assertNotEquals(email1, email2);
    }
}