package com.example.spring01.services;

import com.example.javadb.entities.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientiService {

    Logger logger = LogManager.getLogger(ClientiService.class);

    public List<Cliente> findAll(){

logger.trace("inizio metodo findAll");
        List<Cliente> clienti = new ArrayList<>();

        return clienti;
    }
}
