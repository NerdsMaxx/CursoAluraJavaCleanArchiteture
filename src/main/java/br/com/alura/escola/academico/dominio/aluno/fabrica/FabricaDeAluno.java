package br.com.alura.escola.academico.dominio.aluno.fabrica;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

public class FabricaDeAluno implements IFabricaAluno.IFabricaFinal, IFabricaAluno.INomeCPFEmail {
    
    private Aluno aluno;
    
    private FabricaDeAluno(){}
    
    public static IFabricaAluno.INomeCPFEmail instancia() {
        return new FabricaDeAluno();
    }
    
    public IFabricaAluno.IFabricaFinal comNomeCPFEmail(String nome, String cpf, String email) {
        aluno = new Aluno(cpf, nome, email);
        return this;
    }
    
    public IFabricaAluno.IFabricaFinal comTelefone(String ddd, String numero) {
        aluno.adicionarTelefone(ddd, numero);
        return this;
    }
    
    public Aluno criar() {
        return aluno;
    }
}