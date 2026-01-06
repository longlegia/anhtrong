package com.example.demo.controller;

import com.example.demo.dtos.response.DepartmentResponse;
import com.example.demo.entities.Company;
import com.example.demo.entities.Department;
import com.example.demo.services.CompanyService;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    List<DepartmentResponse> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        for(Department department : departments) {
            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setId(department.getId());
            departmentResponse.setName(department.getName());
            departmentResponses.add(departmentResponse);
        }

        return departmentResponses;
    }
}
