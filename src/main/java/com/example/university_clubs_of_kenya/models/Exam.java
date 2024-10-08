package com.example.university_clubs_of_kenya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class Exam {
    @Id
    Integer id;
    String name;
    AggregateReference<Business, Integer> businessId;
}
