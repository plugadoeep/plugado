package br.edu.fumep.entity;

import br.edu.fumep.config.RoleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by arabasso on 21/08/15.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails, java.io.Serializable {
    private static final long serialVersionUID = -6113123348770067062L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String senha;
    private boolean ativo;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Funcao> funcoes;

	protected Usuario(){
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.ativo = true;
        this.funcoes = new HashSet<>();

        adicionarFuncao("ROLE_USUARIO");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return funcoes
                .stream()
                .map(RoleGrantedAuthority::new)
                .collect(toList());
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return ativo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public long getId() {
        return id;
    }

    public void mudarSenha(String password){
        this.senha = password;
    }

    public void adicionarFuncao(String name){
        funcoes.add(new Funcao(this, name));
    }

    public void removerFuncao(String role){
        funcoes.removeIf(r -> r.getNome() == role);
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
