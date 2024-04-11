package com.eventBooking.serviceImplementation;

import com.eventBooking.dtos.request.AppUserRequest;
import com.eventBooking.dtos.request.EventRequest;
import com.eventBooking.dtos.request.EventResponse;
import com.eventBooking.dtos.respnse.AppUserResponse;
import com.eventBooking.exceptions.EmailAlreadyExistsException;
import com.eventBooking.exceptions.InvalidDateFormatException;
import com.eventBooking.exceptions.InvalidPasswordException;
import com.eventBooking.exceptions.InvalidUserNameLengthException;
import com.eventBooking.model.AppUser;
import com.eventBooking.model.Event;
import com.eventBooking.repository.AppUserRepository;
import com.eventBooking.repository.EventRepository;
import com.eventBooking.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AppUserServiceIMPL implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final EventRepository eventRepository;

    @Override
    public AppUserResponse createAccount(AppUserRequest appUserRequest) {
        if (!isValidEmail(appUserRequest.getEmail())) throw new EmailAlreadyExistsException("invalid email format");
        if (appUserRepository.existsByEmail(appUserRequest.getEmail()))
            throw new EmailAlreadyExistsException("Email already exists");
        validatPassword(appUserRequest.getPassword());

        AppUser appUser = new AppUser();
        appUser.setUsername(appUserRequest.getUsername());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setPassword(appUserRequest.getPassword());
        AppUser savedUser = appUserRepository.save(appUser);

        AppUserResponse appUserResponse = new AppUserResponse();

        appUserResponse.setEmail(savedUser.getEmail());
        appUserResponse.setUsername(savedUser.getUsername());
        return appUserResponse;
    }


    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void validateUserName(String name) {
        if (name == null || name.length() > 100) {
            throw new InvalidUserNameLengthException("Name should not be greater than 100");
        }
    }

    private void validatPassword(String password) {
        if (password.length() > 8) {
            throw new InvalidPasswordException("password must be minimum of 8 character");
        }
    }

    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
//        validDateFormat((eventRequest.getDate()));
        Event events = new Event();
        events.setName(eventRequest.getName());
        events.setEventDescription(eventRequest.getEventDescription());
        events.setNumberOfAttendees(eventRequest.getNumberOfAttendees());
        events.setCategory(eventRequest.getCategory());
        events.setCreatedDate(LocalDateTime.now());
        Event savedEvent = eventRepository.save(events);

        EventResponse eventResponse = new EventResponse();
        eventResponse.setName(savedEvent.getName());
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
            throw new IllegalArgumentException("Available attendees count must be a positive integer between 0 and 1000.");
        }

    }
}