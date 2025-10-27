package dev.jeroen.plushie_backend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;
import dev.jeroen.plushie_backend.exceptions.IncorrectUsernamePasswordCombinationException;
import dev.jeroen.plushie_backend.exceptions.MissingRequiredVariableException;
import dev.jeroen.plushie_backend.exceptions.NotFoundException;
import dev.jeroen.plushie_backend.exceptions.NotUniqueException;
import dev.jeroen.plushie_backend.exceptions.ViolatingContstrainsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<String> handleCustomRuntimeException(CustomRuntimeException exception) {
        HttpStatus status = exception.getStatus();
        if (status == null){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(exception.getMessage(), status);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "Not Found");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<Map<String, String>> handleNotUniqueException(NotUniqueException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "Not Unique");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingRequiredVariableException.class)
    public ResponseEntity<Map<String, String>> handleMissingRequiredVariableException(
            MissingRequiredVariableException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "Missing Required Variable");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ViolatingContstrainsException.class)
    public ResponseEntity<Map<String, String>> handleViolatingContstrainsException(
            ViolatingContstrainsException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "Violating Constrains");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectUsernamePasswordCombinationException.class)
    public ResponseEntity<Map<String, String>> handleIncorrectUsernamePasswordCombinationException(
            IncorrectUsernamePasswordCombinationException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "Incorrect Username Password Combination");
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
