package br.edu.fumep.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "notificacao")
public class Notificacao implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private LocalDate dataNotificacao;
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
