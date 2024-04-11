package com.eventBooking.dtos.request;

import com.eventBooking.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EventRequest {
    private String name;
    private Integer numberOfAttendees;
    private String date;
    private String eventDescription;
    private Category category;
}
