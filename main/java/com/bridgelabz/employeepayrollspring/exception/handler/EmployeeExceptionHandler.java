package com.bridgelabz.employeepayrollspring.exception.handler;

import com.bridgelabz.employeepayrollspring.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollspring.util.ResponseClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseClass> handleBetException(EmployeeNotFoundException he) {
        ResponseClass response = new ResponseClass();
        response.setMessage(he.getMessage());
        response.setErrorCodes(400);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
