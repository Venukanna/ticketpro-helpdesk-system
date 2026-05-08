package com.helpdesk.smart_helpdesk_ticketing.serviceImpl;

import com.helpdesk.smart_helpdesk_ticketing.dto.TeamRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.Team;
import com.helpdesk.smart_helpdesk_ticketing.repository.TeamRepository;
import com.helpdesk.smart_helpdesk_ticketing.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    @Override
    public Team createTeam(TeamRequestDTO request){
        Team team = new Team();
        team.setTeamName(request.getTeamName());

        team.setDescription(request.getDescription());

        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }
}
