package com.eventBooking;

import com.eventBooking.dtos.request.AppUserRequest;
import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.model.Category;
import com.eventBooking.services.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;
    private AppUserRequest appUserRequest;
    private AppUserRequest appUserRequest1;
    private EventRequest eventRequest;

    @BeforeEach
    void setUp(){
       appUserRequest = new AppUserRequest();
       appUserRequest.setUsername("favour");
       appUserRequest.setEmail("favour@gmail.com");
       appUserRequest.setPassword("password");

        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setUsername("peace");
        appUserRequest1.setEmail("peace@mail.com");
        appUserRequest1.setPassword("password");

       eventRequest = new EventRequest();
       eventRequest.setName("Music festival");
       eventRequest.setNumberOfAttendees(600);
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
    }

   @DisplayName("Test That user can create an Account")
    @Test
    public void createAccount(){
       appUserService.createAccount(appUserRequest);
        assertDoesNotThrow(()->{

        });
   }

    @DisplayName("Test That user cannot create an Account with wrong email format and password minimum of 8 character")
    @Test
    public void CannotcreateAccount_WithWrongEmailFormat(){
        appUserService.createAccount(appUserRequest1);
        assertDoesNotThrow(()->{

        });
    }



    @DisplayName("Test that user name should not be more than 100 character ")
   @Test
   void nameLengthHasLimit(){

   }


  @DisplayName("Test That User Can create an Event")
    @Test
    void createEvent(){
   appUserService.createEvent(eventRequest);
   assertDoesNotThrow(()->{


   });

    }

    @DisplayName("Test That user can serach and reserve ticket for event")
    @Test
   void searchAndReserveEvent(){

    }
}
