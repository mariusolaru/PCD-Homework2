package com.example.pcd.controllers;

import com.example.pcd.entities.model.Person;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    @MessageMapping("/persons")
    @SendTo("/topic/messages")
    public Person send(String message) throws Exception{
        Person person = new Person();
        person.setId(1L);
        person.setName("Giani");
        person.setAddress("Complex");

        return person;
    }

}
