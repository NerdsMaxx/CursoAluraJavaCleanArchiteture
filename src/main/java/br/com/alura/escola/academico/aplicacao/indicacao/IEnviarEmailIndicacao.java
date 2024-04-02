package br.com.alura.escola.academico.aplicacao.indicacao;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

public interface IEnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}