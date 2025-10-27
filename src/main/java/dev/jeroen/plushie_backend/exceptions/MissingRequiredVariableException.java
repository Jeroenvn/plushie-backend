package dev.jeroen.plushie_backend.exceptions;

public class MissingRequiredVariableException extends RuntimeException {

    public MissingRequiredVariableException(String message) {
        super(message);
    }

}
