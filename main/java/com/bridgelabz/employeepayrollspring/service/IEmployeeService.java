package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeeModel;

public interface IEmployeeService {
    String helloMessage();

    EmployeeModel addEmployee(EmployeeDTO employeeDto);

    EmployeeModel updateEmployee(Long id, EmployeeDTO employeeDto);

    EmployeeModel deleteEmployee(Long id);

    EmployeeModel getEmployeeById(Long id);

}
