package br.edu.fumep.entity;

import javax.persistence.*;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "mensagem")
public class Mensagem implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private GrupoEstudo grupoEstudo;
    @ManyToOne
    private Aluno aluno;
    private String mensagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
        this.grupoEstudo = grupoEstudo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}