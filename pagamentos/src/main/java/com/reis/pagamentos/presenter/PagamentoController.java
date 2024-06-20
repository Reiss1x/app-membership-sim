package com.reis.pagamentos.presenter;

import com.reis.pagamentos.core.model.Pagamento;
import com.reis.pagamentos.core.services.PagamentoService;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {
    @Autowired
    private PagamentoService ps;

    @PostMapping("/registrarpagamento")
    public void registerPagamento(@RequestBody Pagamento pagamento){
        ps.registerPagamento(pagamento);
    }
}
