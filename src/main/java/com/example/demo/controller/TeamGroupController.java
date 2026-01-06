package com.example.demo.controller;

import com.example.demo.dtos.response.TeamGroupResponse;
import com.example.demo.entities.Employee;
import com.example.demo.entities.TeamGroup;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.TeamGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamgroup")
public class TeamGroupController {

    @Autowired
    TeamGroupService teamGroupService;

    @GetMapping
    List<TeamGroupResponse> getTeamGroups() {
        List<TeamGroup> teamGroups = teamGroupService.getTeamGroups();
        List<TeamGroupResponse> teamGroupResponses = new ArrayList<>();
        for(TeamGroup teamGroup : teamGroups) {
            TeamGroupResponse teamGroupResponse = new TeamGroupResponse();
            teamGroupResponse.setId(teamGroup.getId());
            teamGroupResponse.setName(teamGroup.getName());
            teamGroupResponses.add(teamGroupResponse);
        }

        return teamGroupResponses;
    }
}
