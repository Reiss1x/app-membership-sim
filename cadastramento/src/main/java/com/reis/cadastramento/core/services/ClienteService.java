package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.Cliente;
import com.reis.cadastramento.core.model.Cliente;
import com.reis.cadastramento.core.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<Cliente> getAllCliente(){
        return (List<Cliente>) repo.findAll();
    }

    public Cliente createCliente(Cliente aplicativo){
        return repo.save(aplicativo);
    }

    public Cliente updateCliente(Cliente cliente){
        Optional<Cliente> tempClient = repo.findByCod(cliente.getCod());
        if(tempClient.isPresent()){
            Cliente client = tempClient.get();
            client.setNome(cliente.getNome());
            client.setEmail(cliente.getEmail());
            return client;
        }
        return null;
    }
}
