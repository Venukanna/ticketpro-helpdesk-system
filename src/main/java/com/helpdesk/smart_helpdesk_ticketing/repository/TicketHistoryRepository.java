//package com.helpdesk.smart_helpdesk_ticketing.repository;
//
//import com.helpdesk.smart_helpdesk_ticketing.model.TicketHistory;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface TicketHistoryRepository
//        extends JpaRepository<TicketHistory, Long> {
//
//}

package com.helpdesk.smart_helpdesk_ticketing.repository;

import com.helpdesk.smart_helpdesk_ticketing.model.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketHistoryRepository
        extends JpaRepository<TicketHistory, Long> {

    List<TicketHistory>
    findByTicketIdOrderByUpdatedAtAsc(
            Long ticketId
    );

}