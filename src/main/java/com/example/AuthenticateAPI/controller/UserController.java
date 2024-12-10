package com.example.AuthenticateAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/home")
    public Map<String, Object> getUserHome() {
        // Sample response (replace with real user data)
        Map<String, Object> response = new HashMap<>();
        response.put("username", "John Doe");
        response.put("role", "USER");
        return response;
    }
}
