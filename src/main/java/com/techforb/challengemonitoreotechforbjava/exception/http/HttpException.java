package com.techforb.challengemonitoreotechforbjava.exception.http;

import org.springframework.http.HttpStatus;

/**
 * Clase base para excepciones HTTP.
 */
public abstract class HttpException extends RuntimeException {
    public HttpException(String cause, HttpStatus status) {
        super(cause);
    }
}
