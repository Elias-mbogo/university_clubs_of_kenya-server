package com.example.university_clubs_of_kenya.repositories;

import com.example.university_clubs_of_kenya.models.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
