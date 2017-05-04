package br.edu.fumep.form;

import java.util.Date;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class NotificacaoForm {
    
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
