package com.example.university_clubs_of_kenya.services;

import com.example.university_clubs_of_kenya.models.Chapter;
import com.example.university_clubs_of_kenya.models.dto.ChapterName;
import com.example.university_clubs_of_kenya.repositories.ChapterRepository;
import com.example.university_clubs_of_kenya.repositories.CourseRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpertService {
    CourseRepository courseRepository;
    ChapterRepository chapterRepository;

    public ExpertService(CourseRepository courseRepository, ChapterRepository chapterRepository){
        this.courseRepository = courseRepository;
        this.chapterRepository = chapterRepository;
    }

    public List<ChapterName> getCourseChapters(){
        Iterable<Chapter> chapterResults = chapterRepository.findByCourseId(AggregateReference.to(1));

        List<Chapter> newChapters = new ArrayList<>();
        chapterResults.forEach(newChapters::add);

        List<Chapter> chapters = StreamSupport.stream(chapterResults.spliterator(), false)
                .toList();
        List<ChapterName> chapterNameList = new ArrayList<>();

        for(Chapter chapter: chapters){
            chapterNameList.add(new ChapterName(chapter.getTitle()));
        }

        return  chapterNameList;
    }

    public List<ChapterName> addAndGetCourseChapters(ChapterName chapterName){
        chapterRepository.save(new Chapter(null, chapterName.getName(), null, AggregateReference.to(1)));

        Iterable<Chapter> chapterResults = chapterRepository.findByCourseId(AggregateReference.to(1));
        List<Chapter> newChapters = new ArrayList<>();
        chapterResults.forEach(newChapters::add);

        List<Chapter> chapters = StreamSupport.stream(chapterResults.spliterator(), false)
                .toList();
        List<ChapterName> chapterNameList = new ArrayList<>();

        for(Chapter chapter: chapters){
            chapterNameList.add(new ChapterName(chapter.getTitle()));
        }

        return  chapterNameList;
    }


}
