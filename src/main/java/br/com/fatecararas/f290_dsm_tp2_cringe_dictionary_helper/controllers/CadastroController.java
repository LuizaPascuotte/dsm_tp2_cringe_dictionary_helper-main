package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services.PalavraService;

@Controller
@RequestMapping("/")
public class CadastroController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("palavra", new Palavra());
        return "index";
    }

    @Autowired
    private PalavraService service;

    @PostMapping("dicionario/salvar")
    public String salvar(@ModelAttribute("palavra") Palavra palavra) {
        service.adicionar(palavra);
        return "redirect:/dicionario";
    }

}
