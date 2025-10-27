package dev.jeroen.plushie_backend.exceptions;

import org.springframework.http.HttpStatus;

public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    private String message;
    private HttpStatus status;

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
