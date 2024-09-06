package com.example.university_clubs_of_kenya.repositories;

import com.example.university_clubs_of_kenya.models.Chapter;
import com.example.university_clubs_of_kenya.models.Course;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;


public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
    Iterable<Chapter> findByCourseId(AggregateReference<Course, Integer> courseId);
}
