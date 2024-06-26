package com.eventBooking.dtos.request;

import com.eventBooking.model.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventRequest {
    private String eventName;
    private String customerEmail;
    private Integer numberOfAttendees;
    private String date;
    private String eventDescription;
    private Category category;
}
