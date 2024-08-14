package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Usersz {
    @Id
    Integer id;
    String username;
    String password;
    Boolean enabled;
}
