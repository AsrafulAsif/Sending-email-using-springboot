package com.example.sendingemail.controller;

import com.example.sendingemail.exeption.BadRequestException;
import com.example.sendingemail.rasponse.SimpleResponseRest;
import com.example.sendingemail.request.SendingEmailRequest;
import com.example.sendingemail.service.SendingMailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send-mail")
public class SendingEmail {
    private final SendingMailService sendingMailService;
    @Autowired
    public SendingEmail(SendingMailService sendingMailService) {
        this.sendingMailService = sendingMailService;
    }


    @PostMapping
    ResponseEntity<SimpleResponseRest> sendMailToUser(
            @Valid @RequestBody SendingEmailRequest request
            ){
        sendingMailService.sendEmail(request);
        SimpleResponseRest response  = new SimpleResponseRest();
        response.setCode(200);
        response.setMessage("Success");
        return ResponseEntity.ok(response);
    }
}
