package br.edu.fumep.entity;

import javax.persistence.*;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "controle_aluno")
public class ControleUsuario implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private GrupoEstudo grupoEstudo;
    @ManyToOne
    private Aluno aluno;
    private int nivel;

    protected ControleUsuario() {
    }

    public ControleUsuario(GrupoEstudo grupoEstudo, Aluno aluno, int nivel) {
        this.grupoEstudo = grupoEstudo;
        this.aluno = aluno;
        this.nivel = nivel;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
