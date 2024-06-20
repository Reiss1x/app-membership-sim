package com.reis.assinaturas_validas;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String FANOUTEXCHANGENAME = "pagamentos.pagamento-request";;
    public static final String QUEUENAME = "pagamentos.pagamento-request.save-pagamento";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTEXCHANGENAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUENAME);
    }

    @Bean
    public Binding binding(Queue q, FanoutExchange f) {
        return BindingBuilder.bind(q).to(f);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter messageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}