package com.mmendoza.blog.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mmendoza.blog.models.exceptions.InvalidNameException;
import com.mmendoza.blog.models.exceptions.NotFoundException;

@ControllerAdvice //capturo las excepciones globales
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<String> handlerIlegalArgumentException(InvalidNameException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
