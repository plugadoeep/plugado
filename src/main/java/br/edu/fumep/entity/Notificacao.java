/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.entity;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Notificacao {
    
    private long Id;
    private Date dataNotificacao;
    private String descricaoNotificacao;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public String getDescricaoNotificacao() {
        return descricaoNotificacao;
    }

    public void setDescricaoNotificacao(String descricaoNotificacao) {
        this.descricaoNotificacao = descricaoNotificacao;
    }
    
    
    
}
