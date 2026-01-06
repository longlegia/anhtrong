package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import com.example.demo.entities.TeamGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeamGroupRepository extends JpaRepository<TeamGroup, UUID> {
    public List<TeamGroup> findAll();
}
