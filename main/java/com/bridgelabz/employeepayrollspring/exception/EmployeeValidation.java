package com.bridgelabz.employeepayrollspring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeValidation {
    private int errorCode;
    private String message;

    public EmployeeValidation() {
    }
}
