package com.example.pcd.services;

import com.example.pcd.entities.model.Person;
import com.example.pcd.entities.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


@Service
public class PersonServiceImpl implements PersonService
{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll()
    {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person)
    {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobId blobId = BlobId.of("photos-buck", "test");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
        Blob blob = storage.create(blobInfo, "Hello, Cloud Storage!".getBytes(UTF_8));

        return personRepository.save(person);
    }
}
