package com.helpdesk.smart_helpdesk_ticketing.model;

import com.helpdesk.smart_helpdesk_ticketing.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        updatedAt = LocalDateTime.now();
    }

}