package com.helpdesk.smart_helpdesk_ticketing.rules;

import com.helpdesk.smart_helpdesk_ticketing.enums.Category;
import org.springframework.stereotype.Component;


@Component
public class AssignmentEngine {
    public String assignTeam(Category category){
        switch (category){
            case NETWORK :
                return "Network Team";
            case HARDWARE:
               return "Desktop Support Team";
            case SOFTWARE:
                return "Application Support Team";
            case  ACCESS:
                return "IAM Team";
            case SERVER:
              return "Infra Team";

            default:
                return "General Support";
        }
    }
}
