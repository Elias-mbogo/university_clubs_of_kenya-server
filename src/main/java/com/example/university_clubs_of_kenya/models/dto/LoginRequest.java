package com.example.university_clubs_of_kenya.models.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
