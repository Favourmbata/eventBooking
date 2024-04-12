package com.eventBooking.serviceImplementation;


import com.eventBooking.dtos.request.TicketRequest;
import com.eventBooking.dtos.respnse.TicketResponse;
import com.eventBooking.exceptions.EmailAlreadyExistsException;
import com.eventBooking.exceptions.EmailNotNullException;
import com.eventBooking.model.TicketReservation;
import com.eventBooking.repository.TicketReservationRepository;
import com.eventBooking.services.AppUserService;
import com.eventBooking.services.TicketReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TicketReservationServiceImp implements TicketReservationService {
    private final TicketReservationRepository ticketReservationRepository;
    private final AppUserService appUserService;
    @Override
    public TicketReservation searchAndReserveTicket(TicketRequest ticketRequest) {
        if (ticketRequest.getCustomerEmail() == null)throw new  EmailNotNullException("Email is null");
        if (ticketReservationRepository.existsByEventNameAndCustomerEmail(ticketRequest.getEventName(),ticketRequest.getCustomerEmail()))
            throw new EmailAlreadyExistsException("user with the email "+ticketRequest.getCustomerEmail()+"already have an event reserved "+ticketRequest.getEventName());
        TicketReservation reservation = new TicketReservation();
        reservation.setEventType(ticketRequest.getEventType());
        reservation.setEventName(ticketRequest.getEventName());
        reservation.setNumberOfTickets(ticketRequest.getNumberOfTickets());
        reservation.setCustomer(appUserService.getAppUserByEmail(ticketRequest.getCustomerEmail()));
        reservation.setEventTime(LocalDateTime.now());
        TicketReservation reservedTicket = ticketReservationRepository.save(reservation);

       TicketResponse ticketResponse = new TicketResponse();
        ticketResponse.setEventType(reservedTicket.getEventType());
        ticketResponse.setEventName(reservedTicket.getEventName());
        ticketResponse.setNumberOfTickets(reservedTicket.getNumberOfTickets());
        return reservation;

    }
}
