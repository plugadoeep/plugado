package br.edu.fumep.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by arabasso on 09/05/2017.
 */
public class GrupoEstudoTests {
    private GrupoEstudo grupoEstudo;
    private Aluno aluno;
    private Usuario usuario;

    @Before
    public void inicializacao() {
        grupoEstudo = new GrupoEstudo();

        grupoEstudo.setNome("Amigos");
        grupoEstudo.setCurso("Ciência da Computação");
        grupoEstudo.setMateria("Engenharia de Software II");
        grupoEstudo.setProfessor("José da Silva");
        grupoEstudo.setCoordenador("João dos Santos");

        List<GrupoEstudoAluno> gruposEstudoAlunos = new ArrayList<>();

        usuario = new Usuario();

        aluno = new Aluno("Paulo", usuario);

        gruposEstudoAlunos.add(new GrupoEstudoAluno(grupoEstudo, aluno));

        grupoEstudo.setGruposEstudoAluno(gruposEstudoAlunos);
    }

    @Test
    public void alunoEstaInseridoGrupo() {
        assertThat(grupoEstudo.alunoEstaInserido(aluno), is(true));
    }

    @Test
    public void alunoNuloEstaInseridoGrupo() {
        assertThat(grupoEstudo.alunoEstaInserido(null), is(false));
    }

    @Test
    public void temTags(){
        assertThat(grupoEstudo.temTags(), is(false));
    }

    @Test
    public void tagsVazia() {
        assertThat(grupoEstudo.getTags(), is(""));
    }

    @Test
    public void variasTags() {
        Tag tag1 = new Tag("Álgebra");
        Tag tag2 = new Tag("Cálculo");

        grupoEstudo.setGruposEstudoTag(new ArrayList<>());
        grupoEstudo.getGruposEstudoTag().add(new GrupoEstudoTag(grupoEstudo, tag1));
        grupoEstudo.getGruposEstudoTag().add(new GrupoEstudoTag(grupoEstudo, tag2));

        assertThat(grupoEstudo.getTags(), is("Álgebra, Cálculo"));
    }
}
