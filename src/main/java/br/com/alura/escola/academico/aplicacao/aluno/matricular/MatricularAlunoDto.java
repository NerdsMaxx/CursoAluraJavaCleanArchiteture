package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.fabrica.FabricaDeAluno;

import static java.util.Objects.requireNonNull;

public record MatricularAlunoDto(String nome, String cpf, String email) {
    
    public MatricularAlunoDto(String nome, String cpf, String email) {
        this.nome = requireNonNull(nome);
        this.cpf = requireNonNull(cpf);
        this.email = requireNonNull(email);
    }
    
    public Aluno criarAluno() {
        return FabricaDeAluno
                .instancia()
                .comNomeCPFEmail(nome, cpf, email)
                .criar();
    }
}