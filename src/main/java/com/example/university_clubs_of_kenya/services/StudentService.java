package com.example.university_clubs_of_kenya.services;

import com.example.university_clubs_of_kenya.models.UniChat;
import com.example.university_clubs_of_kenya.models.Usersz;
import com.example.university_clubs_of_kenya.repositories.ClubStudentRepository;
import com.example.university_clubs_of_kenya.repositories.UniChatRepository;
import com.example.university_clubs_of_kenya.repositories.UserszRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    ClubStudentRepository clubStudentRepository;
    UniChatRepository uniChatRepository;
    UserszRepository usersRepository;

    public StudentService(ClubStudentRepository clubStudentRepository, UniChatRepository uniChatRepository){
        this.clubStudentRepository = clubStudentRepository;
        this.uniChatRepository = uniChatRepository;
    }

    public UniChat postMessage(Integer id){
        return uniChatRepository.save(new UniChat(null, "Welcome to the new group", AggregateReference.to(id), null));
    }

    public Usersz postUser(Usersz users){
        return usersRepository.save(users);
    }
}
