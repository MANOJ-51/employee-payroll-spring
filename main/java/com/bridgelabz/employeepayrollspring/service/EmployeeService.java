package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollspring.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import com.bridgelabz.employeepayrollspring.repository.IEmployeeRepository;
import com.bridgelabz.employeepayrollspring.util.ResponseClass;
import com.bridgelabz.employeepayrollspring.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    TokenUtil tokenUtil;

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

    @Override
    public ResponseClass login(String emailId, String password) {
        Optional<EmployeeModel> isEmailPresent = iEmployeeRepository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()){
            if (isEmailPresent.get().getPassword().equals(password)){
                String token = tokenUtil.createToken(isEmailPresent.get().getEmployeeID());
                return new ResponseClass(200,"Login Success",token);
            }else {
                throw new EmployeeNotFoundException(400,"Password is Incorrect");
            }
        }
        throw new EmployeeNotFoundException(400,"No Data Found");
    }

    @Override
    public List<EmployeeModel> getEmployeeData(String token) {
        Long employeeId = tokenUtil.decodeToken(token);
        Optional<EmployeeModel> isEmployeePresent = iEmployeeRepository.findById(employeeId);
        if (isEmployeePresent.isPresent()){
            List<EmployeeModel> getAllEmployee = iEmployeeRepository.findAll();
            if (getAllEmployee.size()>0){
                return getAllEmployee;
            }else {
                throw new EmployeeNotFoundException(400,"No Data");
            }
        }
        throw new EmployeeNotFoundException(400,"Token is Present");
    }

}
