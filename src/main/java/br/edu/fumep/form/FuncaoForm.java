package br.edu.fumep.form;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class FuncaoForm {
    private long id;
    private String nome;
    private long usuarioId;

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
