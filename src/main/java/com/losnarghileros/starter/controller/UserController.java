package com.losnarghileros.starter.controller;

import com.losnarghileros.starter.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
