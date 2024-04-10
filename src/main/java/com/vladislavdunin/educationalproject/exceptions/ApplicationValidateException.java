package com.vladislavdunin.educationalproject.exceptions;

public class ApplicationValidateException extends RuntimeException {
    public ApplicationValidateException(String message) {
        super(message);
    }
}
