package com.ms.msappointment.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        //recebendo messagem com paylods json e convertendo para emaildto
        ObjectMapper objectMapper = new ObjectMapper();

        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
