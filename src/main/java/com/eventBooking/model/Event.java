package com.eventBooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numberOfAttendees;
    private String eventDescription;
    @Enumerated(EnumType.STRING)
    private Category category;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;
}
