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

    @Autowired
    MailService mailService;

    @Override
    public String helloMessage() {
        return "Hello Manoj";
    }
    @Override
    public EmployeeModel addEmployee(EmployeeDTO employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDto);
        employeeModel.setRegisterDate(LocalDateTime.now());
        iEmployeeRepository.save(employeeModel);
        String body="Employee is added successfully with employeeId :-"+employeeModel.getEmployeeID()+employeeDto;
        String subject="Employee Registration Successful";
        mailService.send(employeeModel.getEmailId(),subject,body);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(String token,Long id, EmployeeDTO employeeDto) {
        Long employeeId = tokenUtil.decodeToken(token);
        Optional<EmployeeModel> isEmployeePresent = iEmployeeRepository.findById(employeeId);
        if (isEmployeePresent.isPresent()) {
            isEmployeePresent.get().setFirstName(employeeDto.getFirstName());
            isEmployeePresent.get().setLastName(employeeDto.getLastName());
            isEmployeePresent.get().setSalary(employeeDto.getSalary());
            isEmployeePresent.get().setCompanyName(employeeDto.getCompanyName());
            isEmployeePresent.get().setUpdatedDate(LocalDateTime.now());
            isEmployeePresent.get().setAge(employeeDto.getAge());
            isEmployeePresent.get().setEmailId(employeeDto.getEmailId());
            isEmployeePresent.get().setPassword(employeeDto.getPassword());
            iEmployeeRepository.save(isEmployeePresent.get());
            String body = "Employee Contact is updated successfully with employee id "+isEmployeePresent.get().getEmployeeID();
            String subject = "Employee updated successfully";
            mailService.send(employeeDto.getEmailId(),subject,body);
            return isEmployeePresent.get();

        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }

    @Override
    public EmployeeModel deleteEmployee(String token) {
        Long employeeId = tokenUtil.decodeToken(token);
        Optional<EmployeeModel> isPresent = iEmployeeRepository.findById(employeeId);
        if (isPresent.isPresent()) {
            iEmployeeRepository.delete(isPresent.get());
            String body="Employee is deleted successfully with employeeId :-"+isPresent.get().getEmployeeID();
            String subject="Employee Removed Successfully";
            mailService.send(isPresent.get().getEmailId(),subject,body);
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
        throw new EmployeeNotFoundException(400,"Token is Invalid");
    }

}
