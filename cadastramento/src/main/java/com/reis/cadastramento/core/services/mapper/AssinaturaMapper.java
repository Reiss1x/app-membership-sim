package com.reis.cadastramento.core.services.mapper;

import com.reis.cadastramento.core.model.Assinatura;
import com.reis.cadastramento.core.model.requestnresponse.AssinaturaResponse;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaMapper implements Mapper<AssinaturaResponse, Assinatura> {
    @Override
    public AssinaturaResponse map(AssinaturaResponse response, Assinatura assinatura ) {
        response.setCod(assinatura.getCod());
        response.setFimVigencia(assinatura.getFimVigencia());
        response.setCodCli(assinatura.getCodCli());
        response.setInicioVigencia(assinatura.getInicioVigencia());
        response.setCodApp(assinatura.getCodApp());
        return response;
    }
}
