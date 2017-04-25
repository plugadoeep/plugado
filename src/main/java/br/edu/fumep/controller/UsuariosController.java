package br.edu.fumep.controller;

import br.edu.fumep.entity.Usuario;
import br.edu.fumep.form.UsuarioForm;
import br.edu.fumep.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @RequestMapping(value = {"/registrar"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("form", new UsuarioForm("arabasso"));

        return "usuarios/registrar";
    }

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = {"/registrar"}, method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("form") UsuarioForm form, BindingResult bindingResult){

            if (bindingResult.hasErrors()){
                return "usuarios/registrar";
            }

            try{
                Usuario usuario = new Usuario(form.getLogin(), form.getSenha());

                usuarioService.salvar(usuario);
            }

            catch(Exception e){
                bindingResult.rejectValue("login", null, e.getMessage());

            return "usuarios/registrar";
        }

        return "redirect:/login";
    }
}
