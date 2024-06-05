package com.dotsageiv.HomeConnect.core.presentation.handlers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DatabaseHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<List<String>> userDataIntegrityViolation(DataIntegrityViolationException ex) {
        var uniqueFields = Arrays.asList("username", "cpf");

        var errorMessages = uniqueFields.stream()
                .filter(ex.getMessage()::contains)
                .map(field -> String.format("Campo %s já foi registrado.", field))
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorMessages);
    }
}