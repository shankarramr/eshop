package com.gmail.shankar2k5.eshop.userservice.controller;

import com.gmail.shankar2k5.eshop.userservice.dto.UserDTO;
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
    @ApiOperation(value = "Get an user by email address")
    public UserDTO findByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        return userService.findByEmailAddress(emailAddress);
    }

}