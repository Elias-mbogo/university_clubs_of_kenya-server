package com.example.university_clubs_of_kenya.repositories;

import com.example.university_clubs_of_kenya.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}
