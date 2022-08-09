package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeePayroll")
public class EmployeeController {
    @Autowired
    IEmployeeService iemployeeService;

    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return iemployeeService.helloMessage();
    }
}
