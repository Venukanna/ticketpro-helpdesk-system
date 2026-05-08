//
//
//
//package com.helpdesk.smart_helpdesk_ticketing.model;
//
//import com.helpdesk.smart_helpdesk_ticketing.enums.Category;
//import com.helpdesk.smart_helpdesk_ticketing.enums.Priority;
//import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
//
//import jakarta.persistence.*;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "tickets")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Ticket {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long ticketId;
//
//    private String title;
//
//    private String description;
//
//    @Enumerated(EnumType.STRING)
//    private Category category;
//
//    @Enumerated(EnumType.STRING)
//    private Priority priority;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    private String location;
//
//    private String assignedTeam;
//
//    private String assignedEngineer;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//
//    @PrePersist
//    public void prePersist(){
//
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//
//        if(status == null){
//            status = Status.OPEN;
//        }
//
//    }
//
//
//    @PreUpdate
//    public void preUpdate(){
//
//        updatedAt = LocalDateTime.now();
//
//    }
//
//}

package com.helpdesk.smart_helpdesk_ticketing.model;

import com.helpdesk.smart_helpdesk_ticketing.enums.Category;
import com.helpdesk.smart_helpdesk_ticketing.enums.Priority;
import com.helpdesk.smart_helpdesk_ticketing.enums.Status;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String location;

    private String assignedTeam;

    private String assignedEngineer;


    // Employee Details
    private Long employeeId;

    private String employeeName;

    private String employeeEmail;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist(){

        createdAt = LocalDateTime.now();

        updatedAt = LocalDateTime.now();

        if(status == null){

            status = Status.OPEN;

        }

    }


    @PreUpdate
    public void preUpdate(){

        updatedAt = LocalDateTime.now();

    }

}