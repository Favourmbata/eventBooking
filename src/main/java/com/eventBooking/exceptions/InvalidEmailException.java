package com.eventBooking.exceptions;

public class InvalidEmailException extends EventBookingException{
    public InvalidEmailException(){

    }
    public InvalidEmailException(String message){
        super(message);
    }
}
