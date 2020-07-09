package com.hellojava.springapi.controllers;

import com.hellojava.springapi.Models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrintName {

    @RequestMapping("/name")
    public String  Hello(@RequestParam(name="name",defaultValue = "Anu") String name)
    {
        return "Hello "+ name;
    }


    @GetMapping("/names")
    public String  AllNames()
    {
        return "Hello all";
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> FindPerson(@PathVariable int id)
    {
        Person person = null;

        if (id >0 )
        {
            person = new Person(id,"Anu");
        }

        if (person ==null)
        {
            return  new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);
        }
        else
        {
            return  new ResponseEntity<Person>(person, HttpStatus.OK);
        }
    }

}
