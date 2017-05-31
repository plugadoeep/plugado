package br.edu.fumep.entity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by arabasso on 31/05/2017.
 *
 */
public class AlunoTests {

    private Usuario usuario;
    private Aluno aluno;

    @Before
    public void inicializacao() {
        usuario = new Usuario("arabasso", "123");

        aluno = new Aluno();

        aluno.setUsuario(usuario);
        usuario.setAluno(aluno);
    }

    @Test
    public void nivelControle() {
        assertThat(aluno.nivelControle(), is(-1));
    }

    @Test
    public void nivelControleZero() {
        aluno.setControleUsuario(new ControleUsuario(new GrupoEstudo(), aluno, 0));

        assertThat(aluno.nivelControle(), is(0));
    }
}
