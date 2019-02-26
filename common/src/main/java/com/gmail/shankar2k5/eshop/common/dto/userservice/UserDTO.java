package com.gmail.shankar2k5.eshop.common.dto.userservice;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String emailAddress;

    private String firstName;

    private String lastName;

    private String password;

    private int type;

    private int status;

}