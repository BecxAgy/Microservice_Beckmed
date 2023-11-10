package com.ms.msdoctoremail.consumers;

import com.ms.msdoctoremail.dtos.EmailDoctorDTO;
import com.ms.msdoctoremail.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDoctorDTO emailDoctorDTO){
       var emailModel = new EmailModel ();
        BeanUtils.copyProperties(emailDoctorDTO, emailModel);

        //send email
        System.out.println(emailDoctorDTO.emailTo());
    }

}
