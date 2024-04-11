package com.eventBooking.exceptions;

public class InvalidDateFormatException extends EventBookingException{
    public InvalidDateFormatException(){

    }
    public InvalidDateFormatException(String message){
        super(message);
    }
}
