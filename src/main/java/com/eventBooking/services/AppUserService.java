package com.eventBooking.services;

import com.eventBooking.dtos.request.AppUserRequest;
import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.dtos.request.EventResponse;
import com.eventBooking.dtos.respnse.AppUserResponse;


public interface AppUserService {
    AppUserResponse createAccount(AppUserRequest appUserRequest);

    EventResponse createEvent(EventRequest eventRequest);

}
