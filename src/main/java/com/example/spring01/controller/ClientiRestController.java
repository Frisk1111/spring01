package com.example.spring01.controller;


import com.example.javadb.entities.Cliente;
import com.example.spring01.services.ClientiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clienti")
@CrossOrigin(origins="*")
public class ClientiRestController {
    private static Logger log = LogManager.getLogger(com.example.spring01.controller.ClientiRestController.class);

    @Autowired
    ClientiService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> elencoClienti() {
        log.trace("Inizio metodo elencoClienti()");
        List<Cliente> clienti = service.findAll();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }

    @GetMapping("/{id}") // path variable tra parentesi graffe
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
        log.trace("Inizio metodo getClienteById() id={}", id);

        // chiamare il service per farci dare il singolo cliente
        Optional<Cliente> opt = service.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){

        log.trace("inizio metodo delete by id");
        if(service.deleteById(id)) {
            return new ResponseEntity<>("Cliente eliminato", HttpStatus.OK);
        }
        return new ResponseEntity<>("Cliente non trovato", HttpStatus.NOT_FOUND);
    }

}


