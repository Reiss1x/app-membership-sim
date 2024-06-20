package com.reis.pagamentos.core.services;

import com.netflix.discovery.converters.Auto;
import com.reis.pagamentos.core.model.Pagamento;
import com.reis.pagamentos.core.model.PagamentoDTO;
import com.reis.pagamentos.core.model.PagamentoRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepo repo;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private static Logger logger = LogManager.getLogger(PagamentoService.class);

    @Autowired
    private FanoutExchange fanout;

    public void registerPagamento(Pagamento pagamento){
        repo.save(pagamento);
        PagamentoDTO pagamentodto = new PagamentoDTO();
        pagamentodto.setCodAssinatura(pagamento.getCodAssinatura());
        pagamentodto.setData(pagamento.getDataPagamento());
        pagamentodto.setValorPago(pagamento.getValorPago());
        rabbitTemplate.convertAndSend(fanout.getName(), "",pagamentodto);
        logger.info("Message sent to exchange: {}, with routingKey: {}", pagamentodto, "");
    }
}
