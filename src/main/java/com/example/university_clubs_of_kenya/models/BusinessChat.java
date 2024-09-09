package com.example.university_clubs_of_kenya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class BusinessChat {
    @Id
    Integer id;
    String body;
    AggregateReference<Member, Integer> memberId;
}
