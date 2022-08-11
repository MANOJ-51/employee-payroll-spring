package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import com.bridgelabz.employeepayrollspring.util.ResponseClass;

import java.util.List;

public interface IEmployeeService {
    String helloMessage();

    EmployeeModel addEmployee(EmployeeDTO employeeDto);

    EmployeeModel updateEmployee(String token,Long id, EmployeeDTO employeeDto);

    EmployeeModel deleteEmployee(String token);

    EmployeeModel getEmployeeById(Long id);

    ResponseClass login(String emailId, String password);

    List<EmployeeModel> getEmployeeData(String token);
}
