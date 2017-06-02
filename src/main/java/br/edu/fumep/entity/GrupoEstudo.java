package br.edu.fumep.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "grupo_estudo")
public class GrupoEstudo implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    private String professor;
    private String livro;
    private String curso;
    private String local;
    private String materia;
    private String coordenador;
    @OneToMany(mappedBy = "grupoEstudo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("id desc")
    private List<Mensagem> mensagens;
    @OneToMany(mappedBy = "grupoEstudo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GrupoEstudoAluno> gruposEstudoAluno;
    @OneToMany(mappedBy = "grupoEstudo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GrupoEstudoTag> gruposEstudoTag;
    @OneToMany(mappedBy = "grupoEstudo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ControleUsuario> controleUsuarios;

    public List<ControleUsuario> getControleUsuarios() {
        return controleUsuarios;
    }

    public void setControleUsuarios(List<ControleUsuario> controleUsuarios) {
        this.controleUsuarios = controleUsuarios;
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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public List<GrupoEstudoAluno> getGruposEstudoAluno() {
        return gruposEstudoAluno;
    }

    public void setGruposEstudoAluno(List<GrupoEstudoAluno> gruposEstudoAluno) {
        this.gruposEstudoAluno = gruposEstudoAluno;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public boolean alunoEstaInserido(Aluno aluno) {
        return aluno != null && gruposEstudoAluno.stream().anyMatch(a -> a.getAluno().getId() == aluno.getId());
    }

    public List<GrupoEstudoTag> getGruposEstudoTag() {
        return gruposEstudoTag;
    }

    public void setGruposEstudoTag(List<GrupoEstudoTag> gruposEstudoTag) {
        this.gruposEstudoTag = gruposEstudoTag;
    }

    public String getTags() {
        if (!temTags()) return "";

        List<String> strings = getGruposEstudoTag().stream().map(m -> m.getTag().getDescricao()).collect(Collectors.toList());

        return String.join(", ", strings);
    }

    public boolean temTags() {
        return getGruposEstudoTag() != null && !getGruposEstudoTag().isEmpty();
    }
}
