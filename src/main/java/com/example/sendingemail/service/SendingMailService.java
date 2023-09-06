package com.example.sendingemail.service;


import com.example.sendingemail.request.SendingEmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class SendingMailService {

    private final JavaMailSender javaMailSender;
    private final ExecutorService executorService;
    @Autowired
    public SendingMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        this.executorService = Executors.newFixedThreadPool(1);

    }

    public void sendEmail(SendingEmailRequest request){
            CompletableFuture.runAsync(() -> {
                try {
                    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                    simpleMailMessage.setTo(request.getEmail());
                    simpleMailMessage.setSubject(request.getSubject());
                    simpleMailMessage.setText(request.getBody());
                    javaMailSender.send(simpleMailMessage);
                    log.info("done");
                } catch (Exception e) {
                    log.warn(e.getMessage());
                }
            }, executorService);
        }
}

