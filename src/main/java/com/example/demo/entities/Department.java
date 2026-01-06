package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "department")
@NoArgsConstructor
public class Department {
    @Id
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false, columnDefinition = "BINARY(16)")
    private Company company;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamGroup> groups = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "department_employee",
            joinColumns = @JoinColumn(name = "department_id", columnDefinition = "BINARY(16)"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", columnDefinition = "BINARY(16)")
    )
    private List<Employee> employees = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<TeamGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<TeamGroup> groups) {
        this.groups = groups;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}