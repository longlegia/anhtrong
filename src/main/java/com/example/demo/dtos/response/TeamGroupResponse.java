package com.example.demo.dtos.response;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamGroupResponse {
    private UUID id;

    private String name;

    public TeamGroupResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamGroupResponse() {
    }

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
}