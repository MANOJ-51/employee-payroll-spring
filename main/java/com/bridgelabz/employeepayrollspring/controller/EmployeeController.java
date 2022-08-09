package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import com.bridgelabz.employeepayrollspring.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeePayroll")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return iEmployeeService.helloMessage();
    }

    @PostMapping("createEmployee")
    public EmployeeModel createEmployee(@RequestBody EmployeeDTO employeeDto) {
        return iEmployeeService.addEmployee(employeeDto);
    }

    @GetMapping("getEmployee/{id}")
    public EmployeeModel getEmployee(@PathVariable Long id) {
        return iEmployeeService.getEmployeeById(id);
    }

    @PutMapping("editEmployee/{id}")
    public EmployeeModel updateData(@RequestBody EmployeeDTO employeeDto, @PathVariable Long id) {
        return iEmployeeService.updateEmployee(id, employeeDto);
    }


    @DeleteMapping("deleteEmployee/{id}")
    public EmployeeModel deleteEmployee(@PathVariable Long id) {
        return iEmployeeService.deleteEmployee(id);
    }
}
