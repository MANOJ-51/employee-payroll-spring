package com.bridgelabz.employeepayrollspring.service;

import com.bridgelabz.employeepayrollspring.dto.DepartmentDTO;
import com.bridgelabz.employeepayrollspring.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollspring.model.DepartmentModel;
import com.bridgelabz.employeepayrollspring.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    IDepartmentRepository iDepartmentRepository;

    @Override
    public DepartmentModel createDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = new DepartmentModel(departmentDTO);
        departmentModel.setCreatedDate(LocalDateTime.now());
        iDepartmentRepository.save(departmentModel);
        return departmentModel;
    }

    @Override
    public DepartmentModel editDepartment(Long id, DepartmentDTO departmentDTO) {
        Optional<DepartmentModel> isIdPresent = iDepartmentRepository.findById(id);
        if (isIdPresent.isPresent()){
            isIdPresent.get().setDepartmentName(departmentDTO.getDepartmentName());
            isIdPresent.get().setDepartmentDesc(departmentDTO.getDepartmentDesc());
            isIdPresent.get().setUpdatedDate(LocalDateTime.now());
            iDepartmentRepository.save(isIdPresent.get());
            return isIdPresent.get();
        }
        throw new EmployeeNotFoundException(400,"No Department Found");
    }

    @Override
    public List<DepartmentModel> viewList() {
        List<DepartmentModel> getList = iDepartmentRepository.findAll();
        if (getList.size()>0){
            return getList;
        }
        throw new EmployeeNotFoundException(400,"No Data Found");
    }

    @Override
    public DepartmentModel removeDepartment(Long id) {
        Optional<DepartmentModel> isIdPresent = iDepartmentRepository.findById(id);
        if (isIdPresent.isPresent()){
            iDepartmentRepository.delete(isIdPresent.get());
            return isIdPresent.get();
        }
        throw new EmployeeNotFoundException(400,"Department not found");
    }


}
