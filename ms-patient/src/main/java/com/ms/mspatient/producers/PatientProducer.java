package com.ms.mspatient.producers;

import com.ms.mspatient.dtos.EmailDTO;
import com.ms.mspatient.models.Patient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PatientProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${broker.queue.patient.name}")
    private String routingKey;



    public void publishMessageEmail(Patient Patient){
        String subject = "Cadastro realizado!";
        String text = "Olá, paciente "+ Patient.getName() + "\nSeja bem-vindo ao beckmed! ";
        var emailDto = new EmailDTO();
        emailDto.setPatientId(Patient.getId());
        emailDto.setEmailTo(Patient.getEmail());
        emailDto.setSubject(subject);
        emailDto.setText(text);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
