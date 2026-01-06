package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {
    @Id
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    private String name;
    private String email;

    @ManyToMany(mappedBy = "employees")
    private List<Department> departments = new ArrayList<>();

    @ManyToMany(mappedBy = "members")
    private List<TeamGroup> groups = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<TeamGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<TeamGroup> groups) {
        this.groups = groups;
    }
}