package com.example.demoHostel.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String username;
    private String password;
    private String email;
}
