package com.example.demoHostel.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User not found with username: " + username);
    }
}

