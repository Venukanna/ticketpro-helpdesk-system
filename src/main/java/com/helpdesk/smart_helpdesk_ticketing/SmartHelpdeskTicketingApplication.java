package com.helpdesk.smart_helpdesk_ticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartHelpdeskTicketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHelpdeskTicketingApplication.class, args);
	}

}
