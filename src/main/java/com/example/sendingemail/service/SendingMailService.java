package com.example.sendingemail.service;


import com.example.sendingemail.request.SendingEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendingMailService {

    private final JavaMailSender javaMailSender;
    @Autowired
    public SendingMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SendingEmailRequest request){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(request.getEmail());
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setText(request.getBody());
        javaMailSender.send(simpleMailMessage);
    }
}
