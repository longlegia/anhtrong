package com.example.demo.controller;

import com.example.demo.dtos.response.EmployeeResponse;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponses.add(employeeResponse);
        }

        return employeeResponses;
    }
}
