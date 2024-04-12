package com.eventBooking;

import com.eventBooking.dtos.request.NotificationRequest;
import com.eventBooking.services.NotificationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class NotificationServiceTest {


    @Autowired
    private NotificationService notificationService;
    private NotificationRequest notificationRequest;







    @DisplayName("Test That user can receive notification before event ")
    @Test
    void sendNotification(){
       notificationService.sendNotification(notificationRequest);
        assertDoesNotThrow(()->{

        });
}








}
