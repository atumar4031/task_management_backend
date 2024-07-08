package com.attech.auth;

import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private String cornfirmPassword;
}
