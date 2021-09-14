package com.cgm.ProjectManager.exceptions.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

@AllArgsConstructor
@Getter
@Setter
public class CustomApiException extends RuntimeException{

    public CustomApiException(String message) {
        super(message);
    }

    public CustomApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
