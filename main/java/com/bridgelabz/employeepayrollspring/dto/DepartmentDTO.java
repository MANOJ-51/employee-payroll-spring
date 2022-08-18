package com.bridgelabz.employeepayrollspring.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class DepartmentDTO {
    @NotNull(message = "DepartmentName should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String departmentName;
    @NotNull(message = "DepartmentDesc should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String departmentDesc;
}
