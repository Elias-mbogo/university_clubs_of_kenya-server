package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.Users;
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
    public Users getUser(@RequestBody Users users){
        return studentService.postUser(users);
    }
}
