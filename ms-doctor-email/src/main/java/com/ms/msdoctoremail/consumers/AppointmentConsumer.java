package com.ms.msdoctoremail.consumers;

import com.ms.msdoctoremail.dtos.EmailAppointmentDTO;
import com.ms.msdoctoremail.dtos.EmailDTO;
import com.ms.msdoctoremail.models.EmailAppointmentModel;
import com.ms.msdoctoremail.models.EmailModel;
import com.ms.msdoctoremail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

public class AppointmentConsumer {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${broker.queue.appointment.name}")
    public void listenDoctorQueue(@Payload EmailAppointmentDTO emailDTO){
        var emailModel = new EmailAppointmentModel();
        BeanUtils.copyProperties(emailDTO, emailModel);

        //send email
        emailService.sendEmailAppointment(emailModel);

    }
}
