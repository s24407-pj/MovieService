package com.example.movieservice.advice;

public class MovieValidationException extends Exception {

    public MovieValidationException(String message) {
        super(message);
    }
}

