package br.edu.fumep.entity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class UsuarioTests {

    private Usuario usuario;

    @Before
    public void inicializacao() {
        usuario = new Usuario("arabasso", "123");
    }

    @Test
    public void converterParaUserDetails() {
        UserDetails ud = usuario.toUserDetails();

        assertThat(ud, notNullValue());
    }

    @Test
    public void temFuncao() {
        usuario.adicionarFuncao("ROLE_ADMIN");

        assertThat(usuario.temFuncao("ROLE_ADMIN"), is(true));
    }

    @Test
    public void temAluno() {
        usuario.setAluno(new Aluno(usuario.getLogin(), usuario));
		
		assertThat(usuario.temAluno(), is(true));
    }

    @Test
    public void naoTemFuncao() {
        assertThat(usuario.temFuncao("ROLE_ADMIN"), is(false));
    }

    @Test
    public void ehAdministrador() {
        usuario.adicionarFuncao("ROLE_ADMIN");

        assertThat(usuario.ehAdmin(), is(true));
    }

    @Test
    public void naoEhAdministrador() {
        assertThat(usuario.ehAdmin(), is(false));
    }
}
