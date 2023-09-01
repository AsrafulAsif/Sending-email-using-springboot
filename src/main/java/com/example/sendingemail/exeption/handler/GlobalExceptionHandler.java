package com.example.sendingemail.exeption.handler;


import com.example.sendingemail.exeption.NotFoundException;
import com.example.sendingemail.exeption.error_response.InvalidInputErrorResponse;
import com.example.sendingemail.exeption.error_response.SimpleErrorResponse;
import com.example.sendingemail.exeption.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public InvalidInputErrorResponse handleRequestParameterException(MethodArgumentNotValidException e) {
        String message = "Invalid inputs";
        Integer statusCode = HttpStatus.BAD_REQUEST.value();

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new InvalidInputErrorResponse(message, statusCode,errors);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleErrorResponse handleBadRequestException(Exception e) {
        return new SimpleErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public SimpleErrorResponse handleNotFoundException(Exception e) {
        return new SimpleErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
