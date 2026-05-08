package com.helpdesk.smart_helpdesk_ticketing.rules;

import com.helpdesk.smart_helpdesk_ticketing.enums.Priority;

import org.springframework.stereotype.Component;

@Component
public class PriorityEngine {

    public Priority decidePriority(String description){

        String desc = description.toLowerCase();

        if(desc.contains("server down")){
            return Priority.CRITICAL;
        }

        if(desc.contains("network")
                || desc.contains("internet")){
            return Priority.HIGH;
        }

        if(desc.contains("printer")){
            return Priority.MEDIUM;
        }

        if(desc.contains("password")){
            return Priority.LOW;
        }

        return Priority.MEDIUM;

    }

}