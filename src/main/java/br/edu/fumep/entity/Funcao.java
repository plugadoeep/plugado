package br.edu.fumep.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Entity
@Table(name = "funcao")
public class Funcao implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
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
