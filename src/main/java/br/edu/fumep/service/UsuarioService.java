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
public class UsuarioService {
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Transactional
    public void salvar(Usuario usuario){
        this.usuarioRepositorio.save(usuario);
    }
}
