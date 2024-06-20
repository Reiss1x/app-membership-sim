package com.reis.cadastramento.core.services;

import com.reis.cadastramento.core.model.PagamentoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Receiver {
    @Autowired
    private AssinaturaService as;
    public static final String QUEUENAME = "pagamentos.pagamento-request.save-pagamento";
    private static Logger logger = LogManager.getLogger(Receiver.class);
    @RabbitListener(queues = QUEUENAME)
    public void pagamentoServicoCadastramento(PagamentoDTO dto) {
        logger.info("Mensagem recebida: {}", dto.toString());
        as.setAssinaturaByCod(dto);
    }
}
