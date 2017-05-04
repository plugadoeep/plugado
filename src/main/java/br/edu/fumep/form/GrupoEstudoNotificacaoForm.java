package br.edu.fumep.form;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class GrupoEstudoNotificacaoForm {
    
    private long id;
    private long notificacaoId;
    private long grupoEstudoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNotificacaoId() {
        return notificacaoId;
    }

    public void setNotificacaoId(long notificacaoId) {
        this.notificacaoId = notificacaoId;
    }

    public long getGrupoEstudoId() {
        return grupoEstudoId;
    }

    public void setGrupoEstudoId(long grupoEstudoId) {
        this.grupoEstudoId = grupoEstudoId;
    }
     
     
}
