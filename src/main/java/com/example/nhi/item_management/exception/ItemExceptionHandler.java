package com.example.nhi.item_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionHandler {
    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<Object> exception(ItemNotFoundException e) {
        return new ResponseEntity<>("Cannot find the item", HttpStatus.NOT_FOUND);
    }
}

