package com.sashiri.springdataandjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CartaController {

    //Quando precisamos criar objetos de Carta o autowired diz ao compilador que estamos instanciando diretamente
    //do repository e isso ajuda a ser um pouco mais produtivo sem precisar escrever a mesma linha.
    @Autowired
    CartaRepository cartaRepository;

    //Retorna todas as cartas no bd
    @RequestMapping("/")
    public String listaCartas(Model model){
        model.addAttribute("cartas", cartaRepository.findAll());
        return "lista";
    }

    //Quando formos para o endereço /add irá criar um novo objeto da classe Carta e isso será passado como
    //referência para a view e através da view irei adicionar a informação conforme o model da base de dados
    @GetMapping("/add")
    public String cartaForm(Model model) {
        model.addAttribute("carta", new Carta());
        return "cartaForm";
    }

    //Quando processarmos a informação ele irá validar a carta para sabermos se esta tudo conforme preciso.
    @PostMapping("/process")
    public String processForm(@Valid Carta carta, BindingResult result) {
        if(result.hasErrors()) {
            return "cartaForm";
        }
        cartaRepository.save(carta);
        return "redirect:/";
    }
}