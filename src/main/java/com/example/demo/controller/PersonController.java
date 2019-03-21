package com.example.demo.controller;

import com.example.demo.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot! " +person.getName() + " " + person.getAge() + " " + person.getEnglish_name();
    }
}
