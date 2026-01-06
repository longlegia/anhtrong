package com.example.demo.services;

import com.example.demo.entities.Company;
import com.example.demo.entities.Department;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments;
    }
}
