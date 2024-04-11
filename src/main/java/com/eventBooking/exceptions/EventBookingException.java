package com.eventBooking.exceptions;

public class EventBookingException extends RuntimeException{

    public EventBookingException(){

    }

  public EventBookingException(String message){
        super(message);
  }
}
