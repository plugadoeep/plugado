package br.edu.fumep.entity;

import br.edu.fumep.config.RoleGrantedAuthority;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String login;
    @NotBlank
    private String senha;
    private boolean ativo;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Funcao> funcoes;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Aluno aluno;

	protected Usuario(){
    }

    public Usuario(String login) {
        this.login = login;
        this.ativo = true;
        this.funcoes = new HashSet<>();

        adicionarFuncao("ROLE_USER");
    }

    public Usuario(String login, String senha) {
        this(login);

        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha) {
        this(login, senha);

        aluno = new Aluno(nome, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Set<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Set<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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

    public boolean ehAdmin() {
        return temFuncao("ROLE_ADMIN");
    }

    public boolean temFuncao(String funcao) {
        return getFuncoes().stream().anyMatch(m -> m.getNome().equals(funcao));
    }

    public boolean temAluno() {
        return getAluno() != null;
    }
}
