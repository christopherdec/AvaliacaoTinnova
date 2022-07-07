package com.tinnova.cadastroveiculos.controller;

import com.tinnova.cadastroveiculos.model.Veiculo;
import com.tinnova.cadastroveiculos.repository.MarcaRepository;
import com.tinnova.cadastroveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CadastroController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listaMarcas", marcaRepository.findAll());
        return "index";
    }

    @ModelAttribute(value = "novoVeiculo")
    public Veiculo newVeiculo() {
        return new Veiculo();
    }

}
