package com.ms.msdoctoremail.consumers;

import com.ms.msdoctoremail.dtos.EmailDTO;
import com.ms.msdoctoremail.models.EmailModel;
import com.ms.msdoctoremail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class DoctorEmailConsumer {
    @Autowired
    private EmailService emailService;


    @RabbitListener(queues = "${broker.queue.doctor.name}")
    public void listenDoctorQueue(@Payload EmailDTO emailDoctorDTO){
        var emailModel = new EmailModel ();
        BeanUtils.copyProperties(emailDoctorDTO, emailModel);

        //send email
        emailService.sendEmail(emailModel);
        System.out.println(emailDoctorDTO.emailTo());
    }
}
