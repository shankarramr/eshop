package com.gmail.shankar2k5.eshop.userservice.service;

import com.gmail.shankar2k5.eshop.userservice.dto.UserDTO;

public interface UserService {

    public UserDTO findByEmailAddress(String emailAddress);

}