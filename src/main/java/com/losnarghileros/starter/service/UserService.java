package com.losnarghileros.starter.service;

import com.losnarghileros.starter.entities.User;
import com.losnarghileros.starter.entities.enums.UserType;
import com.losnarghileros.starter.projections.UserRegister;
import com.losnarghileros.starter.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegister userRegister) {
        userRepository.save(
                new User(
                        userRegister.getUsername(),
                        userRegister.getEmail(),
                        UserType.USER,
                        true,
                        bCryptPasswordEncoder.encode(userRegister.getPassword()),
                        new Date(),
                        new Date(),
                        new Date()
                        ));
    }


}
