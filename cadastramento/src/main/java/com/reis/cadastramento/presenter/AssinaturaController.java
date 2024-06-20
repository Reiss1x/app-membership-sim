package com.reis.cadastramento.presenter;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaRequest;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaResponse;
import com.reis.cadastramento.core.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AssinaturaController {

    @Autowired
    private AssinaturaService as;

    @PostMapping("/servcad/assinaturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Assinatura cadastrarAssinatura(@RequestBody AssinaturaRequest assRequest){
        return as.createAssinatura(assRequest);
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<AssinaturaResponse> getAssinaturaByType(@PathVariable String tipo){
        return as.getAssByType(tipo);
    }

    @GetMapping("/servcad/asscli/{codCli}")
    public List<AssinaturaResponse> getAssinaturaByCliente(@PathVariable Long codCli){
        return as.getAssinaturaByCliente(codCli);

    }
    @GetMapping("/servcad/assapp/{codApp}")
    public List<AssinaturaResponse> getAssinaturaByApp(@PathVariable Long codApp){
        return as.getAssinaturaByApp(codApp);
    }

    @GetMapping("servcad/asscod/{cod}")
    public AssinaturaResponse getAssinaturaByCod(@PathVariable Long cod){
        return as.getAssByCod(cod);
    }
}
