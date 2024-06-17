package com.reis.cadastramento.core.model;

import com.reis.cadastramento.core.model.Aplicativo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AplicativoRepo extends CrudRepository<Aplicativo, Long> {
}
