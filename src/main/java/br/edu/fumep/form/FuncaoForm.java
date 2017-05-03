package br.edu.fumep.form;

import br.edu.fumep.entity.*;
import javax.persistence.*;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Entity
@Table(name = "funcao")
public class FuncaoForm implements java.io.Serializable {
    private static final long serialVersionUID = -615312334271967062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne
    private long usuarioId;

    protected FuncaoForm(){
    }

    public FuncaoForm(long usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    
}
