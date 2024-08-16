package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.dto.TeacherResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @GetMapping("/teacher")
    TeacherResource getFirstCompany(){
        return new TeacherResource("SAFARICOM");
    }
}
