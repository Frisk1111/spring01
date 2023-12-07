package com.example.spring01.services;

import com.example.javadb.entities.Cliente;
import com.example.spring01.repository.ClientiRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClientiService {


    @Autowired
    private ClientiRepo repo;
    Logger logger = LogManager.getLogger(ClientiService.class);

    public List<Cliente> findAll(){

        logger.trace("inizio metodo findAll");
        List<Cliente> clienti = repo.findAll();

        return clienti;
    }

    public Optional<Cliente> findById( Integer id){

        logger.trace("inizio metodo find by id()");

        Optional<Cliente> cliente = repo.findById(id);

        return cliente;

    }
    public boolean deleteById(Integer id) {
        if(findById(id).isEmpty()) { // l'id non corrisponde a nessun cliente
            return false;
        }
        repo.deleteById(id);
        return true;
    }


}
