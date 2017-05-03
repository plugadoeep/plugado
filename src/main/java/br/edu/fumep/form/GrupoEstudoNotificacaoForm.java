/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.form;

import br.edu.fumep.entity.*;

/**
 *
 * @author Leonardo Marchese
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
