package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.AssinaturaRepo;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaRequest;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaResponse;
import com.reis.cadastramento.core.services.mapper.AssinaturaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepo repo;

    @Autowired
    private AssinaturaMapper assMapper;

    public Assinatura createAssinatura(AssinaturaRequest assRequest){
        Assinatura assinatura = new Assinatura();
        assinatura.setCodCli(assRequest.codCli());
        assinatura.setCodApp(assRequest.codApp());
        assinatura.setInicioVigencia(LocalDate.now());
        assinatura.setFimVigencia(LocalDate.now().plusDays(7));
        return repo.save(assinatura);
    }

    public List<AssinaturaResponse> getAssByType(String tipo) {
        List<Assinatura> assinaturas = (List<Assinatura>) repo.findAll();
        List<AssinaturaResponse> response = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        switch (tipo){
            case "TODAS":
                for (Assinatura ass : assinaturas) {
                    AssinaturaResponse assResponse = assMapper.map(new AssinaturaResponse(), ass);
                    if(ass.getFimVigencia().isAfter(hoje)) { assResponse.setStatus("ATIVA"); } else {assResponse.setStatus("CANCELADA");}
                    response.add(assResponse);
                }
                return response;
            case "ATIVAS":
                List<Assinatura> ativas = assinaturas.stream().filter(assinatura1 -> assinatura1.getFimVigencia().isAfter(hoje)).toList();
                for (Assinatura ass : ativas) {
                    AssinaturaResponse assResponse = assMapper.map(new AssinaturaResponse(), ass);
                    assResponse.setStatus("ATIVA");
                    response.add(assResponse);
                }
                return response;
            case "CANCELADAS":
                for (Assinatura ass : assinaturas) {
                    AssinaturaResponse assResponse = assMapper.map(new AssinaturaResponse(), ass);
                    assResponse.setStatus("CANCELADA");
                    response.add(assResponse);
                }
        }
        return null;
    }

    public ResponseEntity<List<Assinatura>> getAllAssinatura(){
        List<Assinatura> assinaturas = (List<Assinatura>) repo.findAll();
        if (assinaturas.isEmpty()) {
            return ResponseEntity.ok(assinaturas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    public List<AssinaturaResponse> getAssinaturaByCliente(Long codCli) {
        List<Assinatura> assinaturas =  repo.findAllByCodCli(codCli);
        List<AssinaturaResponse> response = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (Assinatura ass : assinaturas) {
            AssinaturaResponse assResponse = assMapper.map(new AssinaturaResponse(), ass);
            if(ass.getFimVigencia().isAfter(hoje)) { assResponse.setStatus("ATIVA"); } else {assResponse.setStatus("CANCELADA");}
            response.add(assResponse);
        }

        return response;
    }

    public List<AssinaturaResponse> getAssinaturaByApp(Long codApp) {
        List<Assinatura> assinaturas =  repo.findAllByCodCli(codApp);
        List<AssinaturaResponse> response = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (Assinatura ass : assinaturas) {
            AssinaturaResponse assResponse = assMapper.map(new AssinaturaResponse(), ass);
            if(ass.getFimVigencia().isAfter(hoje)) { assResponse.setStatus("ATIVA"); } else {assResponse.setStatus("CANCELADA");}
            response.add(assResponse);
        }
        return response;
    }




}
