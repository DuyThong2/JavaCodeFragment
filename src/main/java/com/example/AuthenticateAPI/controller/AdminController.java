package com.example.AuthenticateAPI.controller;

import com.example.AuthenticateAPI.dto.UsersDTO;
import com.example.AuthenticateAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @GetMapping("/dashboard")
    public Map<String, Object> getAdminDashboard() {
        // Sample response (replace with real data)
        Map<String, Object> response = new HashMap<>();
        response.put("totalUsers", 150);
        response.put("totalProjects", 25);
        return response;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/logs")
    public ResponseEntity<List<String>> getLogs() {
        // Mocked log data; replace with actual logic to fetch logs.
        List<String> logs = Arrays.asList(
                "User admin_user logged in at 2024-11-30 10:00:00",
                "User mentor_user updated their profile at 2024-11-30 10:05:00",
                "User student_user submitted a request at 2024-11-30 10:10:00"
        );
        return ResponseEntity.ok(logs);
    }
}
