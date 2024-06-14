package com.reis.cadastramento.presenter;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.request.AssinaturaRequest;
import com.reis.cadastramento.core.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssinaturaController {

    @Autowired
    private AssinaturaService as;

    @PostMapping("/servcad/assinaturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Assinatura createAssinatura(@RequestBody AssinaturaRequest assRequest){
        return as.createAssinatura(assRequest);
    }

}
