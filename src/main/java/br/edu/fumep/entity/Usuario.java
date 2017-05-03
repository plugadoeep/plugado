package br.edu.fumep.entity;

import br.edu.fumep.config.RoleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {
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

    public void adicionarFuncao(String name){
        funcoes.add(new Funcao(this, name));
    }

    public void removerFuncao(String role){
        funcoes.removeIf(r -> r.getNome().equals(role));
    }

    public UserDetails toUserDetails() {
        return new User(login, senha, funcoes
                .stream()
                .map(RoleGrantedAuthority::new)
                .collect(toList()));
    }
}
