package com.eventBooking.serviceImplementation;

import com.eventBooking.dtos.request.AppUserRequest;

import com.eventBooking.dtos.respnse.AppUserResponse;
import com.eventBooking.exceptions.EmailAlreadyExistsException;
import com.eventBooking.exceptions.InvalidPasswordException;
import com.eventBooking.exceptions.InvalidUserNameLengthException;
import com.eventBooking.model.AppUser;
import com.eventBooking.repository.AppUserRepository;
import com.eventBooking.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AppUserServiceIMPL implements AppUserService {
    private final AppUserRepository appUserRepository;

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

    @Override
    public AppUser getAppUserByEmail(String eventCreatorEmail) {
        AppUser foundAppUser = appUserRepository.findByEmail(eventCreatorEmail);
        if (foundAppUser == null) throw new RuntimeException("can't find user with emil "+eventCreatorEmail);
        return foundAppUser;
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





}