package com.ms.msappointment.producers;

import com.ms.msappointment.domain.models.Appointment;
import com.ms.msappointment.dtos.EmailAppointmentDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AppointmentProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${broker.queue.email.name}")
    private String routingKey;



    public void publishMessageEmail(Appointment appointment){
        String subject = "Cadastro realizado!";
        String text = "A consulta foi marcada" + "\nSeja bem-vindo ao beckmed! ";
        var emailDto = new EmailAppointmentDTO();
        emailDto.setId(appointment.getId());

        emailDto.setSubject(subject);
        emailDto.setText(text);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
