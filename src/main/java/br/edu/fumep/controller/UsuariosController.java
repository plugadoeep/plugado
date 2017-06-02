package br.edu.fumep.controller;

import br.edu.fumep.entity.Usuario;
import br.edu.fumep.form.UsuarioForm;
import br.edu.fumep.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping(value = {"/registrar"})
    public String register(Model model){
        model.addAttribute("form", new UsuarioForm());

        return "usuarios/registrar";
    }

    @PostMapping(value = {"/registrar"})
    public String register(@Valid @ModelAttribute("form") UsuarioForm form, BindingResult bindingResult){

            if (bindingResult.hasErrors()){
                return "usuarios/registrar";
            }

            try{
                Usuario usuario = new Usuario(form.getNome(), form.getLogin(), form.getSenha());

                usuarioRepositorio.save(usuario);
            }

            catch(Exception e){
                bindingResult.rejectValue("login", null, e.getMessage());

            return "usuarios/registrar";
        }

        return "redirect:/login";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = {"", "/index"})
    public String index(Model model){
        model.addAttribute("list", usuarioRepositorio.findAll());

        return "usuarios/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = {"/editar"})
    public String editar(long id, Model model){
        UsuarioForm form = new UsuarioForm(usuarioRepositorio.findOne(id));

        model.addAttribute("form", form);

        return "/usuarios/editar";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = {"/editar"})
    public String editar(@Valid UsuarioForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "usuarios/editar";
        }

        Usuario u = usuarioRepositorio.findOne(form.getId());

        u.getAluno().setNome(form.getNome());
        u.setLogin(form.getLogin());

        if (form.temSenha()) {
            u.setSenha(form.getSenha());
        }

        u.setAtivo(form.isAtivo());

        usuarioRepositorio.save(u);

        return "redirect:/usuarios/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = {"/excluir"})
    public String excluir(long id){
        usuarioRepositorio.delete(id);

        return "redirect:/usuarios/index";
    }
}
