package com.bridgelabz.employeepayrollspring.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private String department;
    private String companyName;

}
