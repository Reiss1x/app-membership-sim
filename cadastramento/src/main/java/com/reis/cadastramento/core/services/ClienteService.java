package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.Cliente;
import com.reis.cadastramento.core.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<Cliente> getAllCliente(){
        return (List<Cliente>) repo.findAll();
    }
}
