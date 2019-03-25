package com.example.pcd.services;

import com.example.pcd.entities.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person savePerson(Person person);

}
