package com.example.pcd.entities.repository;

import com.example.pcd.entities.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
