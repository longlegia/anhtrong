package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.entities.TeamGroup;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.TeamGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamGroupService {

    @Autowired
    TeamGroupRepository teamGroupRepository;

    public List<TeamGroup> getTeamGroups() {
        List<TeamGroup> teamGroups = teamGroupRepository.findAll();

        return teamGroups;
    }
}
