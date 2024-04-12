package com.eventBooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private Integer numberOfAttendees;
    private String customerEmail;
    private String eventDescription;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
   private AppUser appUser;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;
}
