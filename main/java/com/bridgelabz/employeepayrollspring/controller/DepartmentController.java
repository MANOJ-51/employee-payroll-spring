package com.bridgelabz.employeepayrollspring.controller;

import com.bridgelabz.employeepayrollspring.dto.DepartmentDTO;
import com.bridgelabz.employeepayrollspring.model.DepartmentModel;
import com.bridgelabz.employeepayrollspring.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    IDepartmentService iDepartmentService;

    @PostMapping("/addDepartment")
    public DepartmentModel addDepartment(@RequestBody DepartmentDTO departmentDTO){
        return iDepartmentService.createDepartment(departmentDTO);
    }

    @PutMapping("/updateDepartment/{id}")
    public DepartmentModel updateDepartment (@PathVariable Long id,@RequestBody DepartmentDTO departmentDTO){
        return iDepartmentService.editDepartment(id,departmentDTO);
    }

    @GetMapping("/listDepartment")
    public List<DepartmentModel> getList (){
        return iDepartmentService.viewList();
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public DepartmentModel deleteDepartment(@PathVariable Long id){
        return iDepartmentService.removeDepartment(id);
    }
}
