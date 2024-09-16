package com.example.university_clubs_of_kenya.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamDetails {
    String date;
    String startTime;
    String endTime;
    String examName;
    Integer businessId;
}
