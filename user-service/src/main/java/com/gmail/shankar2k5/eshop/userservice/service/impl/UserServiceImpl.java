package com.gmail.shankar2k5.eshop.userservice.service.impl;

import com.gmail.shankar2k5.eshop.userservice.dto.UserDTO;
import com.gmail.shankar2k5.eshop.userservice.repository.UserRepository;
import com.gmail.shankar2k5.eshop.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

}