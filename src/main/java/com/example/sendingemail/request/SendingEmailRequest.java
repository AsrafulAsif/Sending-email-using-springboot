package com.example.sendingemail.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SendingEmailRequest {
    @NotNull(message = "Email required.")
    @NotEmpty(message = "Email required.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email.")
    private String email;

    @NotNull(message = "Subject required.")
    @NotEmpty(message = "Subject required.")
    private String subject;

    @NotNull(message = "Body required.")
    @NotEmpty(message = "Body required.")
    private String body;


}
