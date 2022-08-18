package com.bridgelabz.employeepayrollspring.repository;

import com.bridgelabz.employeepayrollspring.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<DepartmentModel,Long> {
}
