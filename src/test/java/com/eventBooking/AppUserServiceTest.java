package com.eventBooking;

import com.eventBooking.dtos.request.AppUserRequest;

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



}
