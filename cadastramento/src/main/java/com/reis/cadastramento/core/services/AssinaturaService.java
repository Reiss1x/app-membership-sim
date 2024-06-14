package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.AssinaturaRepo;
import com.reis.cadastramento.core.model.request.AssinaturaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepo repo;

    public Assinatura createAssinatura(AssinaturaRequest assRequest){
        Assinatura assinatura = new Assinatura();
        assinatura.setCodCli(assRequest.codCli());
        assinatura.setCodApp(assRequest.codApp());
        assinatura.setInicioVigencia(LocalDate.now());
        assinatura.setFimVigencia(LocalDate.now().plusDays(7));
        return repo.save(assinatura);
    }

    /*public ResponseEntity<List<Assinatura>> getAllAssinatura(){
        List<Assinatura> assinaturas = (List<Assinatura>) repo.findAll();
        if (assinaturas.isEmpty()) {
            return ResponseEntity.ok(assinaturas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }*/



}
