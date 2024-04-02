package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.aluno.excecao.LimiteQuantidadeTelefone;
import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.academico.dominio.geral.Email;
import br.com.alura.escola.academico.dominio.geral.Telefone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

//Entidade
public class Aluno {
    
    private CPF cpf;
    private String nome;
    private Email email;
    private String senha;
    private List<Telefone> telefoneList = new ArrayList<>();
    
    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = requireNonNull(cpf);
        this.nome = requireNonNull(nome);
        this.email = requireNonNull(email);
    }
    
    public Aluno(String cpf, String nome, String email) {
        this.cpf = new CPF(cpf);
        this.nome = requireNonNull(nome);
        this.email = new Email(email);
    }
    
    public void adicionarTelefone(String ddd, String numero) {
        if(telefoneList.size() >= 2) {
            throw new LimiteQuantidadeTelefone(cpf.numero());
        }
        
        telefoneList.add(new Telefone(ddd, numero));
    }
    
    public CPF getCpf() {
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Email getEmail() {
        return email;
    }
    
    public List<Telefone> getTelefoneList() {
        return Collections.unmodifiableList(telefoneList);
    }
    
    public boolean equalsCPF(CPF cpf) {
        return this.cpf.equals(cpf);
    }
    
    public int getQuantidadeTelefone() {
        return telefoneList.size();
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
               "cpf=" + cpf +
               ", nome='" + nome + '\'' +
               ", email=" + email +
               ", telefoneList=" + telefoneList +
               '}';
    }
}