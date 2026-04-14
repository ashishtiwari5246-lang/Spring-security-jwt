package com.ram.security.controller;

import com.ram.security.model.Users;
import com.ram.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestBody Users user) throws Exception{
     return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) throws Exception{
        return userService.verify(user);
    }
}
