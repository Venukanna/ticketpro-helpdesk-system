

package com.helpdesk.smart_helpdesk_ticketing.controller;

import com.helpdesk.smart_helpdesk_ticketing.dto.TeamRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.Team;
import com.helpdesk.smart_helpdesk_ticketing.service.TeamService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(
            TeamService teamService){
        this.teamService=teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(
            @RequestBody TeamRequestDTO request){

        return ResponseEntity.ok(
                teamService.createTeam(request)
        );

    }
    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(
            @PathVariable Long id){
        teamService.deleteTeam(id);
    }

}