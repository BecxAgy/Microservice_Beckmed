package com.ms.msdoctoremail.services;

import com.ms.msdoctoremail.models.EmailModel;
import com.ms.msdoctoremail.models.StatusEmail;
import com.ms.msdoctoremail.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;
    @Value(value="${spring.mail.username}")
    private String emailFrom;


    @Transactional
    public EmailModel sendEmail(EmailModel emailModel){
        try{
            emailModel.setSendDateTime(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send((message));

            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException m){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(emailModel);
        }
    }

}
