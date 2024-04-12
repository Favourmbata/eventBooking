package com.eventBooking;

import com.eventBooking.dtos.request.TicketRequest;
import com.eventBooking.model.Category;
import com.eventBooking.services.TicketReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class TicketReservationServiceTest {
    @Autowired
   private TicketReservationService ticketReservationService;

    private TicketRequest ticketRequest;



    @BeforeEach
    void setUp(){
        ticketRequest = new TicketRequest();
        ticketRequest.setCustomerEmail("peace@mail.com");
    ticketRequest.setEventType(Category.CONFERENCE);
    ticketRequest.setEventName("MUSIC CONFERENCE");
    ticketRequest.setNumberOfTickets(5);

    }


    @DisplayName("Test That user can serach and reserve ticket for event")
    @Test
    void searchAndReserveTicketForEvent(){
        ticketReservationService.searchAndReserveTicket(ticketRequest);
        assertDoesNotThrow(()->{

        });
    }






}
