package com.eventBooking.dtos.request;

import com.eventBooking.model.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventResponse {
    private String name;
    private Integer numberOfAttendees;
    private String date;
    private String eventDescription;
    private Category category;
}
