package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Business {
    @Id
    Integer id;
    String name;
    AggregateReference<Member, Integer> memberId;
    AggregateReference<BusinessChat, Integer> businessChatId;
}
