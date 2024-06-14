package com.reis.cadastramento.core.model;

import com.reis.cadastramento.core.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
