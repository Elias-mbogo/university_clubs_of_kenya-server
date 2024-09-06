package com.example.university_clubs_of_kenya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class Chapter {
    @Id
    Integer id;
    String title;
    String description;
    AggregateReference<Course, Integer> courseId;
}
