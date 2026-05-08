package com.helpdesk.smart_helpdesk_ticketing.service;
import com.helpdesk.smart_helpdesk_ticketing.dto.StatusUpdateDTO;
import com.helpdesk.smart_helpdesk_ticketing.dto.TicketRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
import com.helpdesk.smart_helpdesk_ticketing.model.TicketHistory;

import java.util.List;
public interface TicketService {
    Ticket createTicket(TicketRequestDTO request);
    Ticket updateStatus(Long ticketId, StatusUpdateDTO request);
    List<Ticket> getAllTickets();
    List<TicketHistory>getTicketHistory(Long ticketId);
}
