package com.bridgelabz.employeepayrollspring.repository;

import com.bridgelabz.employeepayrollspring.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
