package com.helpdesk.smart_helpdesk_ticketing.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EscalationScheduler {
    @Scheduled(fixedRate = 60000)
    public void checkEscalations(){
        System.out.println(
          "Checking overdue tickets..."
        );


    }
}
