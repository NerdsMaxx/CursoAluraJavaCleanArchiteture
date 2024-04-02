package br.com.alura.escola.academico.infra.indicacao;

import br.com.alura.escola.academico.aplicacao.indicacao.IEnviarEmailIndicacao;
import br.com.alura.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMail implements IEnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        //logica de envio de emails com a lib Java Mail
    }
}