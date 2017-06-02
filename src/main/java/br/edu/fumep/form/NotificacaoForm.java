package br.edu.fumep.form;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class NotificacaoForm {
    
    private long Id;
    private LocalDate dataNotificacao;
    @NotBlank
    private String descricaoNotificacao;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public LocalDate getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(LocalDate dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public String getDescricaoNotificacao() {
        return descricaoNotificacao;
    }

    public void setDescricaoNotificacao(String descricaoNotificacao) {
        this.descricaoNotificacao = descricaoNotificacao;
    }
    
    
    
}
