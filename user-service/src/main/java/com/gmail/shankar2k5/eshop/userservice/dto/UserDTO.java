package com.gmail.shankar2k5.eshop.userservice.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
    private int type;
    private int status;
}