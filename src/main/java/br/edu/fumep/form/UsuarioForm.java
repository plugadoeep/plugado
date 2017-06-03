package br.edu.fumep.form;

import br.edu.fumep.entity.Usuario;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class UsuarioForm {
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String login;
    private String senha;
    private String confirmarSenha;
    private boolean ativo;

    public UsuarioForm() {
    }

    public UsuarioForm(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getAluno().getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.confirmarSenha = usuario.getSenha();
        this.ativo = usuario.isAtivo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean temSenha() {
        return getSenha() != null && !getSenha().equals("");
    }
}
