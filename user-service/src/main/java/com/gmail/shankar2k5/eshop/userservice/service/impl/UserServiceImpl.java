package com.gmail.shankar2k5.eshop.userservice.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import com.gmail.shankar2k5.eshop.userservice.dto.UserDTO;
import com.gmail.shankar2k5.eshop.userservice.entity.User;
import com.gmail.shankar2k5.eshop.userservice.exception.UserNotFoundException;
import com.gmail.shankar2k5.eshop.userservice.repository.UserRepository;
import com.gmail.shankar2k5.eshop.userservice.service.UserService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    public UserDTO findUserByEmailAddress(String emailAddress) {
        LOGGER.info("emailAddress: {}", emailAddress);
        User user = userRepository.findUserByEmailAddress(emailAddress);
        if (user != null) {
            return new ModelMapper().map(user, UserDTO.class);
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.size() > 0) {
            Type listType = new TypeToken<List<UserDTO>>() {
            }.getType();
            return new ModelMapper().map(users, listType);
        }
        return null;
    }

}