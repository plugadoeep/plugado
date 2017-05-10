package br.edu.fumep.form;

import br.edu.fumep.entity.Aluno;
import br.edu.fumep.entity.GrupoEstudo;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class MensagemForm {
    
    private long id;
    private long grupoEstudoId;
    private long alunoId;
    private String mensagem;

    public MensagemForm() {
    }

    public MensagemForm(GrupoEstudo grupoEstudo, Aluno aluno) {
        this.grupoEstudoId = grupoEstudo.getId();
        this.alunoId = aluno.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGrupoEstudoId() {
        return grupoEstudoId;
    }

    public void setGrupoEstudoId(long grupoEstudoId) {
        this.grupoEstudoId = grupoEstudoId;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

   

   

    
    
    
    
}
