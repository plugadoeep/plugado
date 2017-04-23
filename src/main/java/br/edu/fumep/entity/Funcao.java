package br.edu.fumep.entity;

import javax.persistence.*;

/**
 * Created by arabasso on 22/08/15.
 */
@Entity
@Table(name = "funcao")
public class Funcao implements java.io.Serializable {
    private static final long serialVersionUID = -615312334271967062L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne
    private Usuario usuario;

    protected Funcao(){
    }

    public Funcao(Usuario usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
