package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.dto.ChapterName;
import com.example.university_clubs_of_kenya.services.ExpertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpertController {
    ExpertService expertService;

    public ExpertController(ExpertService expertService){
        this.expertService = expertService;
    }

    @GetMapping("/chapters")
    public List<ChapterName> getChapters(){
        return expertService.getCourseChapters();
    }

    @PostMapping("/chapter-add")
    public List<ChapterName> addAndGetChapters(@RequestBody ChapterName chapterName){
        return expertService.addAndGetCourseChapters(chapterName);
    }
}
