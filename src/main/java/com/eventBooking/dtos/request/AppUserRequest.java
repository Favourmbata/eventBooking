package com.eventBooking.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppUserRequest {
    private String username;
    private String email;
    private String password;

}
