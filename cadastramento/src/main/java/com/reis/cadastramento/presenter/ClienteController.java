package com.reis.cadastramento.presenter;

import com.reis.cadastramento.core.model.Cliente;
import com.reis.cadastramento.core.model.Cliente;
import com.reis.cadastramento.core.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService cs;

    @GetMapping("/servcad/clientes")
    public List<Cliente> getAllClientes(){
        return cs.getAllCliente();
    }

    @PostMapping("servcad/clientes/")
    public Cliente postCliente(@RequestBody Cliente aplicativo){
        return cs.createCliente(aplicativo);
    }

    @PostMapping("servcad/clientes/update")
    public Cliente updateCliente(@RequestBody Cliente clienteNovo){
        return cs.updateCliente(clienteNovo);
    }

}
