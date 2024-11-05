package com.egg.biblioteca.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MiException extends RuntimeException {

    private String resourceName;

    public MiException(String resourceName) {
        super(String.format("Error: %s ", resourceName));
        this.resourceName = resourceName;
    }
}
