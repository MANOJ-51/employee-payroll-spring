package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import com.bridgelabz.employeepayrollspring.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public String helloMessage() {
        return "Hello Manoj";
    }

    @Override
    public EmployeeModel addEmployee(EmployeeDTO employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDto);
        employeeModel.setRegisterDate(LocalDateTime.now());
        iEmployeeRepository.save(employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeDTO employeeDto) {
        Optional<EmployeeModel> isEmployeePresent = iEmployeeRepository.findById(id);
        if (isEmployeePresent.isPresent()) {
            isEmployeePresent.get().setFirstName(employeeDto.getFirstName());
            isEmployeePresent.get().setLastName(employeeDto.getLastName());
            isEmployeePresent.get().setDepartment(employeeDto.getDepartment());
            isEmployeePresent.get().setSalary(employeeDto.getSalary());
            isEmployeePresent.get().setCompanyName(employeeDto.getCompanyName());
            isEmployeePresent.get().setUpdatedDate(LocalDateTime.now());
            isEmployeePresent.get().setAge(employeeDto.getAge());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }

    @Override
    public EmployeeModel deleteEmployee(Long id) {
        Optional<EmployeeModel> isPresent = iEmployeeRepository.findById(id);
        if (isPresent.isPresent()) {
            iEmployeeRepository.delete(isPresent.get());
            return isPresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        Optional<EmployeeModel> employeeModelOptional = iEmployeeRepository.findById(id);
        if (employeeModelOptional.isPresent()) {
            return employeeModelOptional.get();
        } else {
            throw new EmployeeNotFoundException(400, "Employee Not Found");
        }
    }

}
