package br.edu.fumep.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by arabasso on 09/05/2017.
 */
public class MensagemTests {
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

        aluno = new Aluno("Paulo", new Usuario("paulo"));

        aluno.setId(1);

        gruposEstudoAlunos.add(new GrupoEstudoAluno(grupoEstudo, aluno));

        grupoEstudo.setGruposEstudoAluno(gruposEstudoAlunos);
    }

    @Test
    public void mensagemDoAluno() {
        Mensagem mensagem = new Mensagem(grupoEstudo, aluno);

        assertThat(mensagem.proprioAluno(aluno), is(true));
    }

    @Test
    public void naoEhMensagemDoAluno() {
        Mensagem mensagem = new Mensagem(grupoEstudo, aluno);

        Aluno a = new Aluno("José", new Usuario("ze"));

        a.setId(2);

        assertThat(mensagem.proprioAluno(a), is(false));
    }

    @Test
    public void naoTemArquivo() {
        Mensagem mensagem = new Mensagem(grupoEstudo, aluno);

        assertThat(mensagem.temArquivo(), is(false));
    }

    @Test
    public void temArquivo() {
        Mensagem mensagem = new Mensagem(grupoEstudo, aluno);

        mensagem.setArquivo(new Arquivo(mensagem));

        assertThat(mensagem.temArquivo(), is(true));
    }
}
