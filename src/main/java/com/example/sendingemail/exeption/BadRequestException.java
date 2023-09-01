package com.example.sendingemail.exeption;

public class BadRequestException extends RuntimeException{
    public int statusCode;
    public BadRequestException(String message){
        super((message));
        this.statusCode=400;
    }
}
