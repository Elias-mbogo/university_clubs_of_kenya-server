package com.example.university_clubs_of_kenya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Users {
    @Id
    Integer id;
    String username;
    String password;
    Boolean enabled;
}
