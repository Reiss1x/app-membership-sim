package com.reis.cadastramento.core.services.mapper;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaResponse;

public interface Mapper<E, R> {
    E map(E response, R request);

    AssinaturaResponse map(AssinaturaResponse assResponse, Assinatura assinatura);
}
