package com.reis.pagamentos.core.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepo extends CrudRepository<Pagamento, Long> {
}
