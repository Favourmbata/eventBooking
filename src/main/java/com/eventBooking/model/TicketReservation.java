package com.eventBooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class TicketReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private int numberOfTickets;
    private Category eventType;
    private LocalDateTime eventTime;
    @ManyToOne
    private AppUser customer;

}

