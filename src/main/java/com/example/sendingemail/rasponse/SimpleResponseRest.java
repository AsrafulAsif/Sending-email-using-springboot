package com.example.sendingemail.rasponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponseRest {
    public String message;
    public int statusCode;
}
