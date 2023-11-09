package com.ms.msdoctoremail.consumers;

import com.ms.msdoctoremail.dtos.EmailDoctorDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void linstenEmailQueue(@Payload EmailDoctorDTO emailDoctorDTO){
        System.out.println(emailDoctorDTO.emailTo());
    }

}
