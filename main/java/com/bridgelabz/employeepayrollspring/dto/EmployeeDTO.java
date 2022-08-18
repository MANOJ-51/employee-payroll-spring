package com.bridgelabz.employeepayrollspring.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeDTO {
    @NotNull(message = "FirstName should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String firstName;
    @NotNull(message = "LastName should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String lastName;
    @NotNull(message = "age should not be null")
    private int age;
    @NotNull(message = "salary should not be null")
    private double salary;
    @NotNull(message = "Company name should not be null")
    private String companyName;
    @NotNull(message = "Email should not be null")
    @Pattern(regexp = "[\\w+-]+(\\.[\\w+-]+)*@[\\w]+(\\.[\\w]+)?(?=(\\.[A-Za-z_]{2,3}$|\\.[a-zA-Z]{2,3}$)).*",message = "email regex")
    private String emailId;
    @NotNull(message = "password should not be null")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W])(?=.*[a-z]).{8,}$",message = "password regex")
    private String password;

}
