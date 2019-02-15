package com.gmail.shankar2k5.eshop.userservice.service.impl;

import com.gmail.shankar2k5.eshop.userservice.dto.UserDTO;
import com.gmail.shankar2k5.eshop.userservice.entity.User;
import com.gmail.shankar2k5.eshop.userservice.exception.UserNotFoundException;
import com.gmail.shankar2k5.eshop.userservice.repository.UserRepository;
import com.gmail.shankar2k5.eshop.userservice.service.UserService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO findByEmailAddress(String emailAddress) {
        LOGGER.info("emailAddress: {}", emailAddress);
        User user = userRepository.findByEmailAddress(emailAddress);
        if (user != null) {
            return new ModelMapper().map(userRepository.findByEmailAddress(emailAddress), UserDTO.class);
        }
        throw new UserNotFoundException("User not found");
    }

}