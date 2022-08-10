package com.bridgelabz.employeepayrollspring.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseClass {
    private int errorCodes;
    private String message;
    private Object token;

    public ResponseClass() {
    }
}
