package com.example.university_clubs_of_kenya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping
    String login(){
        return "login";
    }
}
