package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.User;
import com.example.pisio.incidentreportingsystem.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll()
    {
        return userService.findAll();
    }
    @GetMapping("/id/{id}")
    public User findById(@PathVariable Integer id) throws NotFoundException {
        return userService.findById(id);
    }
    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) throws  NotFoundException{
        return userService.findByUsername(username);
    }
}
