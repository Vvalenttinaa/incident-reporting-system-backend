package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.models.dto.User;
import com.example.pisio.incidentreportingsystem.models.requests.LoginRequest;
import com.example.pisio.incidentreportingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home()
    {
        return "Hello home";
    }
    @GetMapping("/secured")
    public String home1()
    {
        return "Hello secured";
    }

}
