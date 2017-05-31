package br.edu.fumep.entity;

import javax.persistence.*;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "grupo_estudo_aluno")
public class GrupoEstudoAluno implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private GrupoEstudo grupoEstudo;
    @OneToOne
    private Aluno aluno;
    private boolean admin;

    protected GrupoEstudoAluno() {
    }

    public GrupoEstudoAluno(GrupoEstudo grupoEstudo, Aluno aluno) {
        this.grupoEstudo = grupoEstudo;
        this.aluno = aluno;
    }

    public GrupoEstudoAluno(GrupoEstudo grupoEstudo, Aluno aluno, boolean admin) {
        this(grupoEstudo, aluno);

        this.admin = admin;
    }

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
