package com.eventBooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appUserId;
    private LocalDateTime deliveryTime;
    private String message;
    private String eventName;
    @ManyToOne
    private AppUser appUser;

}
