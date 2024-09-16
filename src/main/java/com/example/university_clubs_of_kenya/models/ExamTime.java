package com.example.university_clubs_of_kenya.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class ExamTime {
    @Id
    Integer id;
    String date;
    String startTime;
    String endTime;
    Boolean done;
    AggregateReference<Exam, Integer> examId;
}
