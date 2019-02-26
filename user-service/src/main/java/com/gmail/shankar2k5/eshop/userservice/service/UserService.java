package com.gmail.shankar2k5.eshop.userservice.service;

import java.util.List;

import com.gmail.shankar2k5.eshop.common.dto.userservice.UserDTO;

public interface UserService {

    public UserDTO findUserByEmailAddress(String emailAddress);

    public List<UserDTO> findAllUsers();

}