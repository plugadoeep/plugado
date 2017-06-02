package br.edu.fumep.form;

import br.edu.fumep.entity.GrupoEstudo;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class GrupoEstudoForm {
    
    private long id;
    @NotBlank
    private String nome;
    private String professor;
    private String livro;
    private String curso;
    private String local;
    private String materia;
    private String coordenador;

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

    public GrupoEstudoForm() {
    }

    public GrupoEstudoForm(GrupoEstudo grupoEstudo){
        this.id = grupoEstudo.getId();
        this.nome = grupoEstudo.getNome();
        this.curso = grupoEstudo.getCurso();
        this.coordenador = grupoEstudo.getCoordenador();
        this.materia = grupoEstudo.getMateria();
        this.professor = grupoEstudo.getProfessor();
    }
}
