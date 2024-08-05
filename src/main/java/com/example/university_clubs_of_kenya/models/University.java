package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class University {
    @Id
    Integer id;
    String name;
    AggregateReference<UniClub, Integer> uniClubId;
}
