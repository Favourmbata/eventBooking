package com.eventBooking.services;

import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.dtos.request.EventResponse;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest);


}

