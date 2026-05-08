package com.helpdesk.smart_helpdesk_ticketing.service;

import com.helpdesk.smart_helpdesk_ticketing.dto.TeamRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(TeamRequestDTO request);

    List<Team> getAllTeams();

    void deleteTeam(Long id);

}