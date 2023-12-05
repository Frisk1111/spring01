package com.example.spring01.controller;


import com.example.javadb.entities.Cliente;
import com.example.spring01.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/c")
public class ClientiController {


    @Autowired
    private ClientiService clientiService;
    @GetMapping
    public String elencoClienti(Model model){

        List<Cliente> clienti = clientiService.findAll();
        model.addAttribute("elenco-clienti", clienti);

        return "clienti";

    }

}
