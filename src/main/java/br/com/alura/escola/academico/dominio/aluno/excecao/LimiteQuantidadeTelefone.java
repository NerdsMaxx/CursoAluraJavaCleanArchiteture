package br.com.alura.escola.academico.dominio.aluno.excecao;

public class LimiteQuantidadeTelefone extends RuntimeException {
    
    private static final long serialVersionUID = 4296291105628114574L;
    
    public LimiteQuantidadeTelefone(String cpf) {
        super("Aluno " + cpf + " já contém 2 telefones.");
    }
}