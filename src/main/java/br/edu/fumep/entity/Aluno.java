package br.edu.fumep.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "aluno")
public class Aluno implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String curso;
    private String semestre;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mensagem> mensagens;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ControleUsuario> controlesUsuario;

    protected Aluno(){
    }

    public Aluno(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<ControleUsuario> getControlesUsuario() {
        return controlesUsuario;
    }

    public void setControlesUsuario(List<ControleUsuario> controlesUsuario) {
        this.controlesUsuario = controlesUsuario;
    }

    public int nivelControle(GrupoEstudo grupoEstudo) {
        if (grupoEstudo == null || getControlesUsuario().isEmpty()) return -1;

        Optional<ControleUsuario> controleUsuario = getControlesUsuario().stream().filter(a -> a.getGrupoEstudo().getId() == grupoEstudo.getId()).findAny();

        if (!controleUsuario.isPresent()) return -1;

        return controleUsuario.get().getNivel();
    }
}
