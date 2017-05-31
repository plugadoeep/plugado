package br.edu.fumep.entity;

import javax.persistence.*;
import java.util.List;

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
    @OneToOne(mappedBy = "aluno")
    private ControleUsuario controleUsuario;

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

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }

    public int nivelControle() {
        return controleUsuario == null ? -1 : (int)controleUsuario.getNivel();
    }
}
