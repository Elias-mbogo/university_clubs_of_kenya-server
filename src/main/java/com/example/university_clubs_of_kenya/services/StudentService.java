package com.example.university_clubs_of_kenya.services;

import com.example.university_clubs_of_kenya.models.UniChat;
import com.example.university_clubs_of_kenya.models.Users;
import com.example.university_clubs_of_kenya.repositories.ClubStudentRepository;
import com.example.university_clubs_of_kenya.repositories.UniChatRepository;
import com.example.university_clubs_of_kenya.repositories.UsersRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    ClubStudentRepository clubStudentRepository;
    UniChatRepository uniChatRepository;
    UsersRepository usersRepository;

    public StudentService(ClubStudentRepository clubStudentRepository, UniChatRepository uniChatRepository){
        this.clubStudentRepository = clubStudentRepository;
        this.uniChatRepository = uniChatRepository;
    }

    public UniChat postMessage(Integer id){
        return uniChatRepository.save(new UniChat(null, "Welcome to the new group", AggregateReference.to(id), null));
    }

    public Users postUser(Users users){

        return usersRepository.save(new Users(users.getId(), users.getUsername(), users.getPassword(), users.getEnabled()));
    }
}
