package com.bridgelabz.employeepayrollspring.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public String helloMessage() {
        return "Hello Manoj";
    }
}
