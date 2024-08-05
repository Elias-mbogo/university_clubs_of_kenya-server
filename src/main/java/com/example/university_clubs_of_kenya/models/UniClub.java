package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class UniClub {
    @Id
    Integer id;
    String name;
    AggregateReference<ClubStudent, Integer> clubStudentId;
    AggregateReference<Business, Integer> businessId;
    AggregateReference<Patron, Integer> patronId;
    AggregateReference<UniChat, Integer> uniChatId;
}
