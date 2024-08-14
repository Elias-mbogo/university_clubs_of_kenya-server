package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Participant {
    @Id
    Integer id;
    Integer marks;
    AggregateReference<ClubStudent, Integer> clubStudentId;
    AggregateReference<Exam, Integer> examId;
}
