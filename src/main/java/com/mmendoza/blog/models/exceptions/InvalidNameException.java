package com.mmendoza.blog.models.exceptions;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException(String message){
        super(message);
    }
}
