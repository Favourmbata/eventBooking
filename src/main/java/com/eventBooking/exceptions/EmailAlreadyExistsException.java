package com.eventBooking.exceptions;

public class EmailAlreadyExistsException extends EventBookingException{

    public EmailAlreadyExistsException(){

    }
  public EmailAlreadyExistsException(String message){
        super(message);
  }

}
