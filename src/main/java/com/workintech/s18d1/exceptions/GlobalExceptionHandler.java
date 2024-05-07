package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException exception){
        log.error("BurgerException occurred! Exception Details:", exception.getLocalizedMessage());
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }


    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception){
        log.error("Unknown exception occurred! Exception Details:", exception.getLocalizedMessage());
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
