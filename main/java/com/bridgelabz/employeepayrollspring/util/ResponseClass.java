package com.bridgelabz.employeepayrollspring.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseClass {
    private String message;
    private int errorCodes;

    public ResponseClass() {
    }
}
