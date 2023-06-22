package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Palavra;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services.PalavraService;

@Controller
@RequestMapping("/dicionario")
public class PalavraController {

    @Autowired
    private PalavraService service;

    @GetMapping
    public String home(Model model) {
        List<Palavra> palavras = service.obterTodas();
        model.addAttribute("titulo", "Vergonha Alheia");
        model.addAttribute("palavras", palavras);
        model.addAttribute("palavra", new Palavra());
        return "dicionario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        service.excluir(id);
        return "redirect:/dicionario";
    }

    @GetMapping("/editar/{id}")
    public String editar_id(@PathVariable("id") Integer id, Model model) {
        Palavra palavra = service.obterPorId(id);
        model.addAttribute("palavra", palavra);
        return "editar_palavra"; // Nome da página de edição
    }

    @PutMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, @ModelAttribute("palavra") Palavra palavra) {
        palavra.setId(id);
        service.editar(palavra);
        return "redirect:/dicionario";
    }
}
