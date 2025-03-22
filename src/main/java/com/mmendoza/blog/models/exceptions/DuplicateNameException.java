package com.mmendoza.blog.models.exceptions;

public class DuplicateNameException extends RuntimeException{
    public DuplicateNameException(String message) {
        super(message);
    }
}
