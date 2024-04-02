package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.gamificacao.dominio.selo.repositorio.IRepositorioSelo;
import br.com.alura.escola.shared.dominio.cpf.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
    
    private IRepositorioSelo repositorioSelo;
    
    @Override
    public void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repositorioSelo.adicionarSelo(novato);
    }
    
    @Override
    public boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoDeEvento.ALUNO_MATRICULADO);
    }
}