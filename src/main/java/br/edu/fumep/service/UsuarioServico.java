package br.edu.fumep.service;

import br.edu.fumep.entity.Usuario;
import br.edu.fumep.repository.UsuarioRepositorio;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Component
public class UsuarioServico {
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Transactional
    public void salvar(Usuario usuario){
        this.usuarioRepositorio.save(usuario);
    }
}
