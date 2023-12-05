package com.example.spring01.repository;

import com.example.javadb.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientiRepo extends JpaRepository<Cliente, Integer> {


    List<Cliente> findAll();


}
