package com.ms.doctor.producers;

import com.ms.doctor.dto.EmailDoctorDTO;
import com.ms.doctor.model.Doctor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DoctorProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${broker.queue.email.name}")
    private String routingKey;



    public void publishMessageEmail(Doctor doctor){
        String subject = "Cadastro realizado!";
        String text = "Olá, "+ doctor.getName() + "\nSeja bem-vindo ao beckmed! ";
        var emailDto = new EmailDoctorDTO();
        emailDto.setId(doctor.getId());
        emailDto.setEmailTo(doctor.getEmail());
        emailDto.setSubject(subject);
        emailDto.setText(text);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
