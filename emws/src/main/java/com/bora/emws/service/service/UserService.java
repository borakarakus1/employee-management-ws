package com.bora.emws.service.service;


import com.bora.emws.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.bora.emws.model.User;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);


}