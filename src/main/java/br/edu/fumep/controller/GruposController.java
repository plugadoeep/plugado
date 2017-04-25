package br.edu.fumep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Controller
@RequestMapping("/grupos")
public class GruposController {

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(Model model){
        return "grupos/index";
    }
}
