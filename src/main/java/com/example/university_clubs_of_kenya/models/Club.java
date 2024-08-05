package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Club {
    @Id
    Integer id;
    String name;
    AggregateReference<Post, Integer> postId;
    AggregateReference<UniClub, Integer> uniClubId;
}
