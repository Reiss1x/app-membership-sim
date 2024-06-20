package com.reis.cadastramento.core.model;

import com.reis.cadastramento.core.model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByCod(Long cod);
}
