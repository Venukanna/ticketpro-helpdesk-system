package com.helpdesk.smart_helpdesk_ticketing.dto;

import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusUpdateDTO {
    private Status status;
}
