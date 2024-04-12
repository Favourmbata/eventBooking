package com.eventBooking.exceptions;

public class EmailNotNullException extends EventBookingException{
    public EmailNotNullException(){

    }
    public EmailNotNullException(String message){
        super(message);
    }
}
