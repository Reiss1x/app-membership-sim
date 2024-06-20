package com.reis.cadastramento.presenter;

import com.reis.cadastramento.core.model.Aplicativo;
import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.services.AplicativoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AplicativoController {

    @Autowired
    private AplicativoService as;

    @GetMapping("/servcad/aplicativos")
    public List<Aplicativo> getAllAplicativo(){
        return as.getAllAplicativo();
    }

    @PatchMapping("/servcad/aplicativos/{cod}")
    public Optional<Aplicativo> updateAplicativo(@PathVariable Long cod, @RequestBody Float custo){
        return as.updateCusto(cod, custo);
    }

    @PostMapping("servcad/aplicativos/new")
    public Aplicativo postAplicativo(@RequestBody Aplicativo aplicativo){
        return as.createAplicativo(aplicativo);
    }


}
