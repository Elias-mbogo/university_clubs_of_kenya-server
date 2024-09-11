package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.dto.GroupMessage;
import com.example.university_clubs_of_kenya.services.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    //Students Groups
    @PostMapping("/student-messages-add")
    public List<GroupMessage> postAndGetStudentChats(@RequestBody  GroupMessage groupMessage){
        return groupService.addMessageToStudentGroup(groupMessage);
    }

    @GetMapping("/student-messages")
    public List<GroupMessage> getStudentChats(){
        return groupService.getStudentGroupMessages();
    }

    //Expert Groups
    @PostMapping("/experts-messages-add")
    public List<GroupMessage> postAndGetExpertChats(GroupMessage groupMessage){
        return groupService.addMessageToExpertGroup(groupMessage);
    }

    @GetMapping("/experts-messages")
    public List<GroupMessage> getExpertChats(){
        return groupService.getExpertGroupMessages();
    }
}
