package com.example.demoHostel.service;

import com.example.demoHostel.model.UserDto;
import com.example.demoHostel.model.user;
import com.example.demoHostel.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    void saveUser(UserDto userDto);

    user findUserByEmail(String email);
}

