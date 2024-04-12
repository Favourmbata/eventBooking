package com.eventBooking.exceptions;

public class InvalidLengthDescription extends EventBookingException{
    public InvalidLengthDescription (){

    }
    public InvalidLengthDescription(String message){
        super(message);
    }
}
