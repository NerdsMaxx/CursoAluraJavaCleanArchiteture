package br.com.alura.escola.shared.dominio.evento;

public abstract class Ouvinte {
    
    public void processa(Evento evento) {
        if(this.deveProcessar(evento)) {
            this.reageAo(evento);
        }
    }
    
    public abstract void reageAo(Evento evento);
    
    public abstract boolean deveProcessar(Evento evento);
}