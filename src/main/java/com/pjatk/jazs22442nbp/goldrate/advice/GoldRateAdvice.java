package com.pjatk.jazs22442nbp.goldrate.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class GoldRateAdvice {
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleExternalBadRequestException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleExternalNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> handleDateTimeParseException() {
        return ResponseEntity.badRequest().build();
    }
}
