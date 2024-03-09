package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.User;
import com.example.pisio.incidentreportingsystem.models.requests.LoginRequest;
import com.example.pisio.incidentreportingsystem.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) throws NotFoundException {
        return userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
