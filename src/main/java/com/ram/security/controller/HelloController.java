package com.ram.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greeting(HttpServletRequest request) {
        return "Hello World!" +request.getSession().getId();
    }
    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "Ashish !" +request.getSession().getId();
    }
}
