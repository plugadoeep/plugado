package br.edu.fumep.controller;

import br.edu.fumep.entity.*;
import br.edu.fumep.form.GrupoEstudoForm;
import br.edu.fumep.form.MensagemForm;
import br.edu.fumep.repository.*;
import br.edu.fumep.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Controller
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    private GrupoEstudoRepositorio grupoEstudoRepositorio;

    @GetMapping(value = {"", "/index"})
    public String index(Model model){
        List<GrupoEstudo> list = grupoEstudoRepositorio.findAll();

        model.addAttribute("list", list);
        model.addAttribute("usuario", getUsuario());

        return "grupos/index";
    }

    @Secured("ROLE_USER")
    @GetMapping(value = {"/mural"})
    public String mural(Model model){
        Usuario usuario = getUsuario();

        List<Mensagem> list = mensagemRepositorio.mural(usuario.getAluno());

        model.addAttribute("list", list);

        return "grupos/mural";
    }

    @GetMapping(value = {"/criar"})
    public String criar(Model model){
        model.addAttribute("form", new GrupoEstudoForm());

        return "grupos/criar";
    }

    @PostMapping(value = {"/criar"})
    public String criar(@Valid @ModelAttribute("form") GrupoEstudoForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "grupos/criar";
        }

        GrupoEstudo grupoEstudo = new GrupoEstudo();

        grupoEstudo.setNome(form.getNome());
        grupoEstudo.setCurso(form.getCurso());
        grupoEstudo.setCoordenador(form.getCoordenador());
        grupoEstudo.setMateria(form.getMateria());
        grupoEstudo.setProfessor(form.getProfessor());

        grupoEstudo.setGruposEstudoAluno(new ArrayList<>());

        grupoEstudo.getGruposEstudoAluno().add(new GrupoEstudoAluno(grupoEstudo, getUsuario().getAluno()));

        grupoEstudoRepositorio.save(grupoEstudo);

        return "redirect:/grupos/index";
    }

    @GetMapping(value = {"/editar/{id}"})
    public String editar(@PathVariable long id, Model model){
        GrupoEstudo grupoEstudo = grupoEstudoRepositorio.findOne(id);

        if (grupoEstudo == null) {
            return "redirect:/grupos/index";
        }

        model.addAttribute("grupoEstudo", grupoEstudo);
        model.addAttribute("form", new GrupoEstudoForm(grupoEstudo));

        Usuario usuario = getUsuario();

        model.addAttribute("usuario", usuario);
        model.addAttribute("formMensagem", new MensagemForm(grupoEstudo, usuario.getAluno()));

        return "grupos/editar";
    }

    @Autowired
    private MensagemRepositorio mensagemRepositorio;

    @Autowired
    private StorageService storageService;

    @PostMapping(value = {"/mensagem"})
    public String mensagem(@Valid @ModelAttribute("form") MensagemForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/grupos/editar/" + form.getGrupoEstudoId();
        }

        GrupoEstudo grupoEstudo = grupoEstudoRepositorio.findOne(form.getGrupoEstudoId());

        Mensagem mensagem = new Mensagem(grupoEstudo, getUsuario().getAluno(), form.getMensagem());

        mensagemRepositorio.save(mensagem);

        storageService.store(mensagem, form.getArquivo());

        return "redirect:/grupos/editar/" + form.getGrupoEstudoId();
    }

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    GrupoEstudoAlunoRepositorio grupoEstudoAlunoRepositorio;

    @Autowired
    ControleUsuarioRepositorio controleUsuarioRepositorio;

    @GetMapping(value = {"/ingressar/{id}"})
    public String ingressar(@PathVariable long id){
        GrupoEstudo grupoEstudo = grupoEstudoRepositorio.findOne(id);

        Usuario usuario = getUsuario();

        GrupoEstudoAluno grupoEstudoAluno = new GrupoEstudoAluno(grupoEstudo, usuario.getAluno());

        grupoEstudoAlunoRepositorio.save(grupoEstudoAluno);

        ControleUsuario controleUsuario = new ControleUsuario(grupoEstudo, usuario.getAluno(), 1);

        controleUsuarioRepositorio.save(controleUsuario);

        return "redirect:/grupos/index";
    }

    private Usuario getUsuario() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Usuario usuario = usuarioRepositorio.findByLogin(userDetails.getUsername()).get();

        return usuario;
    }
}
