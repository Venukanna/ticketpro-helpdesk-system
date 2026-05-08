//package com.helpdesk.smart_helpdesk_ticketing.controller;
//
//import com.helpdesk.smart_helpdesk_ticketing.dto.StatusUpdateDTO;
//import com.helpdesk.smart_helpdesk_ticketing.dto.TicketRequestDTO;
//import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
//import com.helpdesk.smart_helpdesk_ticketing.service.DashboardService;
//import com.helpdesk.smart_helpdesk_ticketing.service.TicketService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/tickets")
//public class TicketController {
//    private final TicketService ticketService;
//    private final DashboardService dashboardService;
//
//    public TicketController (TicketService ticketService,DashboardService dashboardService){
//        this.ticketService = ticketService;
//        this.dashboardService = dashboardService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Ticket> createTicket(
//            @RequestBody TicketRequestDTO request){
//        Ticket ticket = ticketService.createTicket(request);
//        return ResponseEntity.ok(ticket);
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Ticket> updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO request){
//        return ResponseEntity.ok(ticketService.updateStatus(id,request));
//    }
//    @GetMapping
//    public List<Ticket> getAllTickets(){
//
//        return ticketService.getAllTickets();
//
//    }
//
//    @GetMapping("/dashboard/metrics")
//    public Map<String,Long> metrics(){
//        return dashboardService.getMetrics();
//    }
//}

//package com.helpdesk.smart_helpdesk_ticketing.controller;
//
//import com.helpdesk.smart_helpdesk_ticketing.dto.StatusUpdateDTO;
//import com.helpdesk.smart_helpdesk_ticketing.dto.TicketRequestDTO;
//import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
//import com.helpdesk.smart_helpdesk_ticketing.service.TicketService;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tickets")
//public class TicketController {
//
//    private final TicketService ticketService;
//
//    public TicketController(TicketService ticketService){
//        this.ticketService = ticketService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Ticket> createTicket(
//            @RequestBody TicketRequestDTO request){
//
//        return ResponseEntity.ok(
//                ticketService.createTicket(request)
//        );
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Ticket> updateStatus(
//            @PathVariable Long id,
//            @RequestBody StatusUpdateDTO request){
//
//        return ResponseEntity.ok(
//                ticketService.updateStatus(id, request)
//        );
//    }
//
//    @GetMapping
//    public List<Ticket> getAllTickets(){
//
//        return ticketService.getAllTickets();
//
//    }
//
//}



package com.helpdesk.smart_helpdesk_ticketing.controller;

import com.helpdesk.smart_helpdesk_ticketing.dto.StatusUpdateDTO;
import com.helpdesk.smart_helpdesk_ticketing.dto.TicketRequestDTO;

import com.helpdesk.smart_helpdesk_ticketing.model.Ticket;
import com.helpdesk.smart_helpdesk_ticketing.model.TicketHistory;

import com.helpdesk.smart_helpdesk_ticketing.service.TicketService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;


    public TicketController(
            TicketService ticketService){

        this.ticketService = ticketService;

    }


    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(
            @RequestBody TicketRequestDTO request){

        return ResponseEntity.ok(
                ticketService.createTicket(request)
        );

    }



    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateDTO request){

        return ResponseEntity.ok(
                ticketService.updateStatus(
                        id,
                        request
                )
        );

    }



    @GetMapping
    public List<Ticket> getAllTickets(){

        return ticketService.getAllTickets();

    }



    @GetMapping("/{id}/history")
    public List<TicketHistory> getHistory(
            @PathVariable Long id){

        return ticketService
                .getTicketHistory(id);

    }

}