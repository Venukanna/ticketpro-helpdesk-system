
package com.helpdesk.smart_helpdesk_ticketing.serviceImpl;

import com.helpdesk.smart_helpdesk_ticketing.dto.StatusUpdateDTO;
import com.helpdesk.smart_helpdesk_ticketing.dto.TicketRequestDTO;

import com.helpdesk.smart_helpdesk_ticketing.enums.Status;

import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
import com.helpdesk.smart_helpdesk_ticketing.model.TicketHistory;
import com.helpdesk.smart_helpdesk_ticketing.model.User;

import com.helpdesk.smart_helpdesk_ticketing.repository.TicketHistoryRepository;
import com.helpdesk.smart_helpdesk_ticketing.repository.TicketRepository;
import com.helpdesk.smart_helpdesk_ticketing.repository.UserRepository;

import com.helpdesk.smart_helpdesk_ticketing.rules.AssignmentEngine;
import com.helpdesk.smart_helpdesk_ticketing.rules.PriorityEngine;

import com.helpdesk.smart_helpdesk_ticketing.service.TicketService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final PriorityEngine priorityEngine;
    private final AssignmentEngine assignmentEngine;
    private final TicketRepository ticketRepository;
    private final TicketHistoryRepository ticketHistoryRepository;
    private final UserRepository userRepository;


    public TicketServiceImpl(
            TicketRepository ticketRepository,
            PriorityEngine priorityEngine,
            AssignmentEngine assignmentEngine,
            TicketHistoryRepository ticketHistoryRepository,
            UserRepository userRepository){

        this.ticketRepository = ticketRepository;
        this.priorityEngine = priorityEngine;
        this.assignmentEngine = assignmentEngine;
        this.ticketHistoryRepository = ticketHistoryRepository;
        this.userRepository = userRepository;

    }




    @Override
    public Ticket createTicket(
            TicketRequestDTO request){

        Ticket ticket = new Ticket();

        ticket.setTitle(
                request.getTitle()
        );

        ticket.setDescription(
                request.getDescription()
        );

        ticket.setCategory(
                request.getCategory()
        );

        ticket.setLocation(
                request.getLocation()
        );


        // Employee Details
        ticket.setEmployeeId(
                request.getEmployeeId()
        );

        ticket.setEmployeeName(
                request.getEmployeeName()
        );

        ticket.setEmployeeEmail(
                request.getEmployeeEmail()
        );



        ticket.setPriority(
                priorityEngine.decidePriority(
                        request.getDescription()
                )
        );


        String team =
                assignmentEngine.assignTeam(
                        request.getCategory()
                );

        ticket.setAssignedTeam(team);



        List<User> engineers =
                userRepository.findByTeamSafe(team);

        User selectedEngineer = null;

        long minLoad = Long.MAX_VALUE;


        for(User eng : engineers){

            long load =
                    ticketRepository
                            .countByAssignedEngineerAndStatusNot(
                                    eng.getName(),
                                    Status.CLOSED
                            );

            if(load < minLoad){

                minLoad = load;

                selectedEngineer = eng;

            }

        }


        if(selectedEngineer != null){

            ticket.setAssignedEngineer(
                    selectedEngineer.getName()
            );

        }



        Ticket savedTicket =
                ticketRepository.save(ticket);



        TicketHistory history =
                new TicketHistory();

        history.setTicketId(
                savedTicket.getTicketId()
        );

        history.setStatus(
                savedTicket.getStatus()
        );

        ticketHistoryRepository.save(history);


        return savedTicket;

    }

    @Override
    public Ticket updateStatus(
            Long ticketId,
            StatusUpdateDTO request){

        Ticket ticket =
                ticketRepository.findById(ticketId)
                        .orElseThrow();


        Status currentStatus =
                ticket.getStatus();

        Status newStatus =
                request.getStatus();



        if(currentStatus == Status.OPEN
                && newStatus != Status.IN_PROGRESS){

            throw new RuntimeException(
                    "OPEN tickets can move only to IN_PROGRESS"
            );

        }


        if(currentStatus == Status.IN_PROGRESS
                && newStatus != Status.RESOLVED){

            throw new RuntimeException(
                    "IN_PROGRESS tickets can move only to RESOLVED"
            );

        }


        if(currentStatus == Status.RESOLVED
                && newStatus != Status.CLOSED){

            throw new RuntimeException(
                    "Only employee can close resolved ticket"
            );

        }


        if(currentStatus == Status.CLOSED){

            throw new RuntimeException(
                    "Closed ticket cannot be modified"
            );

        }



        ticket.setStatus(newStatus);


        Ticket updatedTicket =
                ticketRepository.save(ticket);


        TicketHistory history =
                new TicketHistory();

        history.setTicketId(
                updatedTicket.getTicketId()
        );

        history.setStatus(
                updatedTicket.getStatus()
        );

        ticketHistoryRepository.save(history);


        return updatedTicket;

    }



    @Override
    public List<Ticket> getAllTickets(){

        return ticketRepository.findAll();

    }

    @Override
    public List<TicketHistory>
    getTicketHistory(
            Long ticketId){

        return ticketHistoryRepository
                .findByTicketIdOrderByUpdatedAtAsc(
                        ticketId
                );

    }
}