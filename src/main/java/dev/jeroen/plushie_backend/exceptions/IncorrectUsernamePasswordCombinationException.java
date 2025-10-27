package dev.jeroen.plushie_backend.exceptions;

public class IncorrectUsernamePasswordCombinationException extends RuntimeException {

    public IncorrectUsernamePasswordCombinationException(String message) {
        super(message);
    }

}
