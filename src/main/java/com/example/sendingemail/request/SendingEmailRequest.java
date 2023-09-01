package com.example.sendingemail.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendingEmailRequest {
    @NotNull(message = "Email required.")
    @NotEmpty(message = "Email required.")
    private String email;

    @NotNull(message = "Subject required.")
    @NotEmpty(message = "Subject required.")
    private String subject;

    private String body;


}
