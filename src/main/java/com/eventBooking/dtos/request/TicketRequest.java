package com.eventBooking.dtos.request;

import com.eventBooking.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TicketRequest {
    private String eventName;
    private String customerEmail;
    private int numberOfTickets;
    private Category eventType;
    private LocalDateTime eventTime;
}
