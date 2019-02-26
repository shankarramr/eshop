package com.gmail.shankar2k5.eshop.userservice.controller;

import java.util.List;

import com.gmail.shankar2k5.eshop.common.dto.userservice.UserDTO;
import com.gmail.shankar2k5.eshop.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{emailAddress}")
    @ApiOperation(value = "Find an user by email address")
    public UserDTO findUserByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        return userService.findUserByEmailAddress(emailAddress);
    }

    @PostMapping("/findAllUsers")
    @ApiOperation(value = "Find all users")
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

}