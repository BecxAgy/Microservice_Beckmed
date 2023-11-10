package com.ms.msdoctoremail.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean
    public Queue queue(){
        //passando nome da fila e dizendo se é duravel ou não
        return new Queue(this.queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        //recebendo messagem com paylods json e convertendo para emaildto
        ObjectMapper objectMapper = new ObjectMapper();

        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
