package com.bridgelabz.employeepayrollspring.model;

import com.bridgelabz.employeepayrollspring.dto.DepartmentDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "department_spring")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String departmentName;
    private String departmentDesc;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public DepartmentModel(DepartmentDTO departmentDTO) {
        this.departmentName = departmentDTO.getDepartmentName();
        this.departmentDesc = departmentDTO.getDepartmentDesc();
    }

    public DepartmentModel() {
    }
}
