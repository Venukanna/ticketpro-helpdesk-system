//package com.helpdesk.smart_helpdesk_ticketing.dto;
//
//import com.helpdesk.smart_helpdesk_ticketing.enums.Category;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class TicketRequestDTO {
//
//    private String title;
//
//    private String description;
//
//    private Category category;
//
//    private String location;
//}

package com.helpdesk.smart_helpdesk_ticketing.dto;

import com.helpdesk.smart_helpdesk_ticketing.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDTO {

    private String title;

    private String description;

    private Category category;

    private String location;


    // Employee Details
    private Long employeeId;

    private String employeeName;

    private String employeeEmail;

}
