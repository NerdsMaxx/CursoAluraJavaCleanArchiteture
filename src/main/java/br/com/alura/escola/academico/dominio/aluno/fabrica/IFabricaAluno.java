package br.com.alura.escola.academico.dominio.aluno.fabrica;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

public interface IFabricaAluno {
    interface INomeCPFEmail {
        IFabricaFinal comNomeCPFEmail(String nome, String cpf, String email);
    }
    
    interface IFabricaFinal {
        IFabricaFinal comTelefone(String ddd, String numero);
        Aluno criar();
    }
}