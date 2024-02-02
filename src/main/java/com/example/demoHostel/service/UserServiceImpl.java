package com.example.demoHostel.service;

import com.example.demoHostel.model.UserDto;
import com.example.demoHostel.model.user;
import com.example.demoHostel.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        user user = new user();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public user findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    private UserDto mapToUserDto(user user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }


}
