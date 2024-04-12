package com.eventBooking.serviceImplementation;

import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.dtos.request.EventResponse;
import com.eventBooking.exceptions.EmailNotNullException;
import com.eventBooking.exceptions.InvalidDateFormatException;
import com.eventBooking.exceptions.InvalidLengthDescription;
import com.eventBooking.exceptions.InvalidUserNameLengthException;
import com.eventBooking.model.Event;
import com.eventBooking.repository.EventRepository;
import com.eventBooking.repository.TicketReservationRepository;
import com.eventBooking.services.AppUserService;
import com.eventBooking.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final AppUserService appUserService;
    private final TicketReservationRepository ticketReservationRepository;
    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        setAvailableAttendeesCount(eventRequest.getNumberOfAttendees());
        validateEventName(eventRequest.getEventName());
        eventDescriptionLength(eventRequest.getEventDescription());
        if (eventRequest.getCustomerEmail() == null)throw new EmailNotNullException("Event creator email cannot be null");
        if (eventRepository.existsByEventNameAndAppUserEmail
        (eventRequest.getEventName(), eventRequest.getCustomerEmail()))
            throw new  RuntimeException("user with the email "+eventRequest.getCustomerEmail()+"already have an event named "+eventRequest.getEventName());
        Event events = new Event();
        events.setEventName(eventRequest.getEventName());
        events.setEventDescription(eventRequest.getEventDescription());
        events.setNumberOfAttendees(eventRequest.getNumberOfAttendees());
        events.setCategory(eventRequest.getCategory());
         events.setCustomerEmail(eventRequest.getCustomerEmail());
        events.setCreatedDate(LocalDateTime.now());
        events.setAppUser(appUserService.getAppUserByEmail(eventRequest.getCustomerEmail()));
        Event savedEvent = eventRepository.save(events);

        EventResponse eventResponse = new EventResponse();
        eventResponse.setName(savedEvent.getEventName());
        eventResponse.setCategory(savedEvent.getCategory());
        eventResponse.setNumberOfAttendees(savedEvent.getNumberOfAttendees());
        eventResponse.setEventDescription(savedEvent.getEventDescription());
        return eventResponse;
    }



    private void validateEventName(String eventName) {
        if (eventName == null || eventName.length() > 100) {
            throw new InvalidUserNameLengthException("Name exceeds the character limit of 100 characters.");
        }
    }


    private  String validDateFormat(String dateInputed) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateformat.parse(dateInputed);
            return String.format("%s", dateformat.format(date));

        } catch (ParseException e) {
            throw new InvalidDateFormatException("Date formate is invalid,correct format(yyyy-mm-dd)");
        }

    }

    private void setAvailableAttendeesCount(int availableAttendeesCount) {
        if (availableAttendeesCount < 0 || availableAttendeesCount > 1000) {
            throw new IllegalArgumentException("Number of  attendees not Available");
        }

    }
    private void eventDescriptionLength(String eventDescription){

     if ( eventDescription == null || eventDescription .length() > 500 ){
         throw new InvalidLengthDescription("characters should  not be more than 500 ");
     }
    }
}
