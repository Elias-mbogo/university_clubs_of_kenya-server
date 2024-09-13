package com.example.university_clubs_of_kenya.services;

import com.example.university_clubs_of_kenya.models.BusinessChat;
import com.example.university_clubs_of_kenya.models.ClubStudent;
import com.example.university_clubs_of_kenya.models.Member;
import com.example.university_clubs_of_kenya.models.UniChat;
import com.example.university_clubs_of_kenya.models.dto.GroupMessage;
import com.example.university_clubs_of_kenya.repositories.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    UniChatRepository uniChatRepository;
    ClubStudentRepository clubStudentRepository;
    PatronRepository patronRepository;
    BusinessChatRepository businessChatRepository;
    MemberRepository memberRepository;

    public GroupService(UniChatRepository uniChatRepository, ClubStudentRepository clubStudentRepository,
                        PatronRepository patronRepository, BusinessChatRepository businessChatRepository,
                        MemberRepository memberRepository){
        this.uniChatRepository = uniChatRepository;
        this.clubStudentRepository = clubStudentRepository;
        this.patronRepository = patronRepository;
        this.businessChatRepository = businessChatRepository;
        this.memberRepository = memberRepository;
    }

    public List<GroupMessage> addMessageToStudentGroup(GroupMessage groupMessage){
        ClubStudent student = clubStudentRepository.findByName(groupMessage.getUsername());
        uniChatRepository.save(new UniChat(null, groupMessage.getBody(), null, AggregateReference.to(student.getId())));

        List<GroupMessage> newGroupMessages = new ArrayList<>();
        Iterable<UniChat> uniChats = uniChatRepository.findAll();

        for(UniChat uniChat: uniChats){
            AggregateReference<ClubStudent, Integer> clubStudentId = uniChat.getClubStudentId();
            Optional<ClubStudent> newStudent = clubStudentRepository.findById(clubStudentId.getId());
            ClubStudent studentFinal = newStudent.get();
            newGroupMessages.add(new GroupMessage(uniChat.getBody(), studentFinal.getName()));
        }

        return newGroupMessages;

    }

    public List<GroupMessage> getStudentGroupMessages(){
        List<GroupMessage> newGroupMessages = new ArrayList<>();
        Iterable<UniChat> uniChats = uniChatRepository.findAll();

        for(UniChat uniChat: uniChats){
            AggregateReference<ClubStudent, Integer> clubStudentId = uniChat.getClubStudentId();
            Optional<ClubStudent> newStudent = clubStudentRepository.findById(clubStudentId.getId());
            ClubStudent studentFinal = newStudent.get();
            newGroupMessages.add(new GroupMessage(uniChat.getBody(), studentFinal.getName()));
        }

        return newGroupMessages;
    }

    public List<GroupMessage> addMessageToExpertGroup(GroupMessage groupMessage){
        Member member = memberRepository.findByName(groupMessage.getUsername());
        businessChatRepository.save(new BusinessChat(null, groupMessage.getBody(), AggregateReference.to(member.getId())));

        List<GroupMessage> newGroupMessages = new ArrayList<>();
        Iterable<BusinessChat> businessChats = businessChatRepository.findAll();

        for(BusinessChat businessChat: businessChats){
            AggregateReference<Member, Integer> memberId = businessChat.getMemberId();
            Optional<Member> newMember = memberRepository.findById(memberId.getId());
            Member memberFinal = newMember.get();
            newGroupMessages.add(new GroupMessage(businessChat.getBody(), memberFinal.getName()));
        }

        return newGroupMessages;
    }

    public List<GroupMessage> getExpertGroupMessages(){
        List<GroupMessage> newGroupMessages = new ArrayList<>();
        Iterable<BusinessChat> businessChats = businessChatRepository.findAll();

        for(BusinessChat businessChat: businessChats){
            AggregateReference<Member, Integer> memberId = businessChat.getMemberId();
            Optional<Member> newMember = memberRepository.findById(memberId.getId());
            Member memberFinal = newMember.get();
            newGroupMessages.add(new GroupMessage(businessChat.getBody(), memberFinal.getName()));
        }

        return newGroupMessages;
    }

}
