package com.eventBooking.exceptions;

public class InvalidUserNameLengthException extends EventBookingException{
    public InvalidUserNameLengthException(){

    }
    public InvalidUserNameLengthException(String message){
        super(message);
    }
}
