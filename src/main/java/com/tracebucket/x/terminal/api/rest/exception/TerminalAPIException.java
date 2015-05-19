package com.tracebucket.x.terminal.api.rest.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by sadath on 18-May-15.
 */
public class TerminalAPIException extends RuntimeException implements Serializable {

    private String message;

    private HttpStatus httpStatus;

    public TerminalAPIException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}