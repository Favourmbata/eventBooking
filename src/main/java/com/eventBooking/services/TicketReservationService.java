package com.eventBooking.services;

import com.eventBooking.dtos.request.TicketRequest;
import com.eventBooking.model.Notification;
import com.eventBooking.model.TicketReservation;

public interface TicketReservationService {
    TicketReservation searchAndReserveTicket(TicketRequest ticketRequest);

    Notification sendNotification(TicketRequest ticketRequest);

}
