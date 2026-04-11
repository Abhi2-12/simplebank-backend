package com.simplebank.controller;
import com.simplebank.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplebank.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User postMethodName(@RequestBody User user) {
        return userService.registerUser(user);
    } 
    
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
    }
    
}
