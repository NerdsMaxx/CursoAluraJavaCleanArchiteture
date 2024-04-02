package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.aluno.excecao.LimiteQuantidadeTelefone;
import br.com.alura.escola.academico.dominio.aluno.fabrica.FabricaDeAluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {
    
    private Aluno aluno;
    
    @BeforeEach
    void inicializarAluno() {
        this.aluno = FabricaDeAluno
                .instancia()
                .comNomeCPFEmail(
                        "Fulano da Silva",
                        "123.456.789-00",
                        "fulano@gmail.com")
                .criar();
    }
    
    @Test
    void deveriaPermitirAdicionarUmTelefone() {
        this.aluno.adicionarTelefone("11", "99999-9999");
        assertEquals(1, this.aluno.getQuantidadeTelefone());
    }
    
    @Test
    void deveriaPermitirAdicionarDoisTelefones() {
        this.aluno.adicionarTelefone("11", "99999-9999");
        this.aluno.adicionarTelefone("22", "88888-8888");
        assertEquals(2, this.aluno.getQuantidadeTelefone());
    }
    
    @Test
    void naoDeveriaPermitirAdicionarTresTelefones() {
        this.aluno.adicionarTelefone("11", "99999-9999");
        this.aluno.adicionarTelefone("22", "88888-8888");
        assertThrows(
                LimiteQuantidadeTelefone.class,
                () -> this.aluno.adicionarTelefone("33", "77777-7777"));
    }
}