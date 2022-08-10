package com.bridgelabz.employeepayrollspring.repository;

import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    Optional<EmployeeModel> findByEmailId(String emailId);

}
