package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.Usersz;
import com.example.university_clubs_of_kenya.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student-noauth")
    public Usersz getUser(@RequestBody Usersz users){
        return studentService.postUser(users);
    }
}
