package com.example.spring01.controller;


import com.example.javadb.entities.Cliente;
import com.example.spring01.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


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


    @GetMapping("/{id}")
    public ResponseEntity<?> findClienteById(@PathVariable("id") Integer id){

        Optional<Cliente> opt = clientiService.findById(id);

        if(opt.isPresent()){

           return ResponseEntity.ok().body(opt);
        } else {

         return    ResponseEntity.badRequest().body("NOT FOUND");
        }


    }

}
