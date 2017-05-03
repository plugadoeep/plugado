/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.entity;

/**
 *
 * @author aluno
 */
public class GrupoEstudoNotificacao {
    
    private long id;
    private Notificacao notificacao;
    private GrupoEstudo grupoEstudo;
     
    

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
        this.grupoEstudo = grupoEstudo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
     
     
    
}
