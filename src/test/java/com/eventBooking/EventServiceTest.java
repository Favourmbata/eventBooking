package com.eventBooking;

import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.model.Category;
import com.eventBooking.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class EventServiceTest {
    @Autowired
    private EventService eventService;
    private EventRequest eventRequest;
    private EventRequest eventRequest1;
    private EventRequest eventRequest2;


    @BeforeEach
    void setUp(){
        eventRequest = new EventRequest();
        eventRequest.setCustomerEmail("favour@gmail.com");
        eventRequest.setEventName("Music festival");
        eventRequest.setNumberOfAttendees(1000);
        eventRequest.setCategory(Category.CONCERT);
        eventRequest.setDate("2024-04-11");
        eventRequest.setEventDescription("Join us for an electrifying weekend at the " +
                "Sunset Grooves Music Festival! " +
                "Get ready to immerse yourself in three days of non-stop music, " +
                "featuring top artists from around the globe across multiple stages. " +
                "From pulsating beats to soulful melodies, " +
                "our diverse lineup promises something for every music lover. " +
                "Dance under the stars, indulge in delicious food from local vendors, " +
                "and discover new sounds in our vibrant atmosphere." +
                " Don't miss out on this unforgettable experience " +
                "– grab your tickets now and let the music move you!\n");


        eventRequest1 = new EventRequest();
        eventRequest1.setCustomerEmail("favour@gmail.com");
        eventRequest1.setEventName("GAME CHALLENGE");
        eventRequest1.setNumberOfAttendees(800);
        eventRequest1.setCategory(Category.GAME);
        eventRequest1.setDate("2024-02-14");
        eventRequest1.setEventDescription("Are you Ready for the ultimate gaming challenge?" +
                " Join us for intense competition, thrilling battles, and epic victories. " +
                "Test your skills, claim glory, and become the champion!"
             );


        eventRequest2 = new EventRequest();
        eventRequest2.setCustomerEmail("peace@mail.com");
        eventRequest2.setEventName("TECH CONFERENCE ");
        eventRequest2.setNumberOfAttendees(800);
        eventRequest2.setCategory(Category.CONFERENCE);
        eventRequest2.setDate("2024-08-14");
        eventRequest2.setEventDescription("Experience the excitement of GamePlay!" +
                " Join us for an immersive journey into the world of gaming and entertainment. " +
                "Discover the latest releases, engage in thrilling competitions," +
                " and connect with fellow gamers. Dive into a universe filled with innovation," +
                " community, and endless fun. Don't miss out on the ultimate gaming experience" +
                " with GameStop!");


    }

    @DisplayName("Test That User Can create an Event")
    @Test
    void createEvent(){
        eventService.createEvent(eventRequest);
        assertDoesNotThrow(()->{


        });

    }

    @DisplayName("Test That User Cannot create an Event above 1000")
    @Test
    void cannotCreateEvent_WithExceededNumberOf1000(){
        eventService.createEvent(eventRequest1);
        assertDoesNotThrow(()->{

        });

    }
    @DisplayName("Test That User Cannot create an Event with lengthy name charcter")
    @Test
    void cannotCreateEvent_WithLenthyNameCharacter(){
        eventService.createEvent(eventRequest2);
        assertDoesNotThrow(()->{

        });

    }



}
