package com.helpdesk.smart_helpdesk_ticketing.serviceImpl;

import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
import com.helpdesk.smart_helpdesk_ticketing.repository.TicketRepository;
import com.helpdesk.smart_helpdesk_ticketing.service.DashboardService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl
        implements DashboardService {

    private final TicketRepository ticketRepository;

    public DashboardServiceImpl(
            TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }

    @Override
    public Map<String,Long> getMetrics(){

        Map<String,Long> metrics=
                new HashMap<>();

        metrics.put(
                "openTickets",
                ticketRepository.countByStatus(
                        Status.OPEN)
        );

        metrics.put(
                "resolvedTickets",
                ticketRepository.countByStatus(
                        Status.RESOLVED)
        );

        return metrics;

    }

}