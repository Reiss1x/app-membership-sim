package com.reis.cadastramento.core.model;

import com.reis.cadastramento.core.model.Assinatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssinaturaRepo extends CrudRepository<Assinatura, Long> {
    List<Assinatura> findAllByCodCli(Long codCli);
    List<Assinatura> findAllByCodApp(Long codApp);
    Assinatura findByCod(Long cod);
}
