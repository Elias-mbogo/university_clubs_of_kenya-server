package com.example.university_clubs_of_kenya.services;

import com.example.university_clubs_of_kenya.models.Business;
import com.example.university_clubs_of_kenya.models.Exam;
import com.example.university_clubs_of_kenya.models.dto.ExamDetails;
import com.example.university_clubs_of_kenya.repositories.BusinessRepository;
import com.example.university_clubs_of_kenya.repositories.ExamRepository;
import com.example.university_clubs_of_kenya.repositories.ExamTimeRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService {
    ExamRepository examRepository;
    ExamTimeRepository examTimeRepository;
    BusinessRepository businessRepository;

    public ExamService(ExamRepository examRepository, ExamTimeRepository examTimeRepository,
                       BusinessRepository businessRepository){
        this.examRepository = examRepository;
        this.examTimeRepository = examTimeRepository;
        this.businessRepository = businessRepository;
    }

/*    public ExamDetails postAndGetExamDetails(ExamDetails examDetails){
        Exam newExam = examRepository.save(new Exam(null, examDetails.getExamName(), AggregateReference.to(examDetails.getBusinessId())));

    }*/

}
