package com.example.sendingemail.controller;

import com.example.sendingemail.rasponse.SimpleResponseRest;
import com.example.sendingemail.request.SendingEmailRequest;
import com.example.sendingemail.service.SendingMailService;
import com.example.sendingemail.utils.MakingResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send-mail")
public class SendingEmailController {
    private final SendingMailService sendingMailService;
    @Autowired
    public SendingEmailController(SendingMailService sendingMailService) {
        this.sendingMailService = sendingMailService;
    }


    @PostMapping
    ResponseEntity<SimpleResponseRest> sendMailToUser(
            @Valid @RequestBody SendingEmailRequest request
            ){
        SimpleResponseRest response = new SimpleResponseRest();
        sendingMailService.sendEmail(request);
        return MakingResponse.makingResponse(response);
    }
}
