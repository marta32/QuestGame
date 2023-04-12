package com.example.AccesaProject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotEnoughTokensException extends RuntimeException {

    private String message;

    public NotEnoughTokensException(String message) {
        super(message);
        this.message = message;
    }

}