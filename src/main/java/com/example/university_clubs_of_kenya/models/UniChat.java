package com.example.university_clubs_of_kenya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class UniChat {
    @Id
    Integer id;
    String body;
    AggregateReference<Patron, Integer> patronId;
    AggregateReference<ClubStudent, Integer> clubStudentId;
}
