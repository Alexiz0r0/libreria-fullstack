package com.egg.biblioteca.excepciones;

import com.egg.biblioteca.model.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MiException.class)
    public ResponseEntity<ApiResponse> handlerMiException(MiException exception, WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
