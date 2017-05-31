package br.edu.fumep.form;

import br.edu.fumep.entity.Usuario;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class UsuarioForm {
    private long id;
    private String login;
    private String senha;
    private String confirmarSenha;
    private boolean ativo;

    public UsuarioForm() {
    }

    public UsuarioForm(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.confirmarSenha = usuario.getSenha();
        this.ativo = usuario.isAtivo();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}
