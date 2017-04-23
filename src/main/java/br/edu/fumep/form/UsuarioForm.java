package br.edu.fumep.form;

import br.edu.fumep.constraint.EqualFields;
import br.edu.fumep.constraint.UniqueLogin;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@EqualFields(baseField = "senha", matchField = "confirmarSenha")
public class UsuarioForm {
    @UniqueLogin
    @NotBlank
    private String login;
    @NotBlank
    private String senha;
    @NotBlank
    private String confirmarSenha;

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

    public UsuarioForm(){
    }

    public UsuarioForm(String login) {
        this.login = login;
    }
}
