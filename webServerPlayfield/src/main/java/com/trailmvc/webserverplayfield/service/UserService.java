package com.trailmvc.webserverplayfield.service;

import com.trailmvc.webserverplayfield.dto.RegistrationDto;
import com.trailmvc.webserverplayfield.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
