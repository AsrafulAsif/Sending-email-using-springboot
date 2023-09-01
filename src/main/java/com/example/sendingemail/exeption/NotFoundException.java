package com.example.sendingemail.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

    public NotFoundException(String statusMessage){
        super((HttpStatus.NOT_FOUND),statusMessage);
    }
}
