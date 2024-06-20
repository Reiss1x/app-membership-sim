package com.reis.assinaturas_validas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssinaturasController {

    @Autowired
    private AssinaturaService as;

    @GetMapping("assinvalidas/{codAss}")
    public Boolean validAssinatura(@PathVariable Long codAss){
        return as.validAssinatura(codAss);
    }
}
