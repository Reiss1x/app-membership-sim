package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.Aplicativo;
import com.reis.cadastramento.core.model.AplicativoRepo;
import com.reis.cadastramento.core.model.Assinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepo repo;

    public List<Aplicativo> getAllAplicativo(){
        return (List<Aplicativo>) repo.findAll();
    }

    public Aplicativo getAplicativo(Long id) {
        Optional<Aplicativo> app = repo.findById(id);
        if (app.isPresent()){
            return app.get();
        }
        return null;
    }

    public Optional<Aplicativo> updateCusto(Long cod, Float custo){
        Optional<Aplicativo> tempApp = repo.findById(cod);

        if(tempApp.isPresent()) {
            Aplicativo app = tempApp.get();
            app.setCustoMensal(custo);
            repo.save(app);
            return Optional.of(app);
        }
        return Optional.empty();
    }

    public Aplicativo createAplicativo(Aplicativo aplicativo){
        return repo.save(aplicativo);
    }
}
