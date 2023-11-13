package com.ms.msdoctoremail.consumers;

import com.ms.msdoctoremail.dtos.EmailDTO;
import com.ms.msdoctoremail.models.EmailModel;
import com.ms.msdoctoremail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

public class PatientEmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${broker.queue.patient.name}")
    public void listenPatientQueue(@Payload EmailDTO emailDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);

        //send email
        emailService.sendEmail(emailModel);
        System.out.println(emailDTO.emailTo());
    }
}
