package com.eventBooking.services;

import com.eventBooking.dtos.request.AppUserRequest;
import com.eventBooking.dtos.respnse.AppUserResponse;
import com.eventBooking.model.AppUser;


public interface AppUserService {
    AppUserResponse createAccount(AppUserRequest appUserRequest);


    AppUser getAppUserByEmail(String eventCreatorEmail);


}

