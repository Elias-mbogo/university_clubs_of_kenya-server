package com.example.university_clubs_of_kenya.controllers;

import com.example.university_clubs_of_kenya.models.dto.GroupMessage;
import com.example.university_clubs_of_kenya.services.GroupService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    //Students Groups
    public List<GroupMessage> postAndGetStudentChats(GroupMessage groupMessage){
        return groupService.addMessageToStudendGroup(groupMessage);
    }

    public List<GroupMessage> getStudentChats(){
        return groupService.getStudentGroupMessages();
    }

    //Expert Groups
    public List<GroupMessage> postAndGetExpertChats(GroupMessage groupMessage){
        return groupService.addMessageToExpertGroup(groupMessage);
    }

    public List<GroupMessage> getExpertChats(){
        return groupService.getExpertGroupMessages();
    }
}
