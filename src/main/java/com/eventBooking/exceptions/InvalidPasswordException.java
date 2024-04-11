package com.eventBooking.exceptions;

public class InvalidPasswordException extends EventBookingException{

    public InvalidPasswordException(){

    }
    public InvalidPasswordException(String message){
        super(message);
    }
}
