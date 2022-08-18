package com.bridgelabz.employeepayrollspring.model;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "EmployeeDetails")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeID;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    @OneToOne
    private DepartmentModel departmentModel;
    private String companyName;
    private String emailId;
    private String password;
    private LocalDateTime registerDate;
    private LocalDateTime updatedDate;

    public EmployeeModel(EmployeeDTO employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.age = employeeDto.getAge();
        this.salary = employeeDto.getSalary();
        this.companyName = employeeDto.getCompanyName();
        this.emailId = employeeDto.getEmailId();
        this.password=employeeDto.getPassword();
    }

    public EmployeeModel() {
    }
}
