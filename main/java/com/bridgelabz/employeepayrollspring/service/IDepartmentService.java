package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.DepartmentDTO;
import com.bridgelabz.employeepayrollspring.model.DepartmentModel;

import java.util.List;

public interface IDepartmentService {
    DepartmentModel createDepartment(DepartmentDTO departmentDTO);

    DepartmentModel editDepartment(Long id, DepartmentDTO departmentDTO);

    List<DepartmentModel> viewList();

    DepartmentModel removeDepartment(Long id);
}
