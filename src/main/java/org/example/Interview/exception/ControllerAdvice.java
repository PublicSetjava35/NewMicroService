package org.example.Interview.exception;

import org.example.Interview.dto.ErrException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrException> responseEntityIllegal(IllegalArgumentException ex) {
        ErrException exception = new ErrException(404, ex.getMessage());
        return ResponseEntity.badRequest().body(exception);
    }
}