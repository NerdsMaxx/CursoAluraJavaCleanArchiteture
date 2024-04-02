package br.com.alura.escola.academico.dominio.aluno.excecao;

import br.com.alura.escola.shared.dominio.cpf.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    
    private static final long serialVersionUID = - 4139302492122999874L;
    
    public AlunoNaoEncontrado(final CPF cpf) {
        super("Aluno não encontrado com este " + cpf.numero() + "!");
    }
}