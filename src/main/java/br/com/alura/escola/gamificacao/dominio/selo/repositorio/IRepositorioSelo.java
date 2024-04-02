package br.com.alura.escola.gamificacao.dominio.selo.repositorio;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;

import java.util.List;

public interface IRepositorioSelo {
    
    void adicionarSelo(Selo selo);
    List<Selo> selosDoAlunoDeCPF(CPF cpf);
}