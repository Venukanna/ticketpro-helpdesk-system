//
//package com.helpdesk.smart_helpdesk_ticketing.repository;
//
//import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
//import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//public interface TicketRepository
//        extends JpaRepository<Ticket, Long> {
//  long countByStatus(Status status);
//}

package com.helpdesk.smart_helpdesk_ticketing.repository;

import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {

  long countByStatus(Status status);

  long countByAssignedEngineerAndStatusNot(
          String assignedEngineer,
          Status status
  );

}