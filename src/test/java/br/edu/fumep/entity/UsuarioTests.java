package br.edu.fumep.entity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

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
}
