package com.attech.user;

import lombok.Data;

import java.util.UUID;
@Data
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String phone;

    private String email;

}
