package br.com.alura.escola.gamificacao.infra.selo;

import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.dominio.selo.repositorio.IRepositorioSelo;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toUnmodifiableList;

public class RepositorioSeloMemoria implements IRepositorioSelo {
    
    private List<Selo> seloList = new ArrayList<>();
    
    @Override
    public void adicionarSelo(Selo selo) {
        seloList.add(selo);
    }
    
    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return seloList.stream().filter(selo -> selo.getCpfDoAluno().equals(cpf))
                       .collect(toUnmodifiableList());
    }
}