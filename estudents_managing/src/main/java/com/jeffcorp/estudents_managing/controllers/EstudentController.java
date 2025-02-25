package com.jeffcorp.estudents_managing.controllers;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffcorp.estudents_managing.domain.Estudent;

@RestController
@RequestMapping("/estudents")
public class EstudentController {
    private List<Estudent> estudents = new ArrayList<>(Arrays.asList(
            new Estudent(1, "Julian", "Julian@gmail.com", 10, "7A"),
            new Estudent(2, "Jose", "Jose@gmail.com", 15, "9B"),
            new Estudent(3, "Josefina", "Josefina@gmail.com", 19, "11C"),
            new Estudent(4, "Esteban", "Esteban@gmail.com", 16, "10B")));

    @GetMapping
    public List<Estudent> getEstudents() {
        return estudents;
    }

    @GetMapping("/{email}")
    public Estudent getEstudentEMAIL(@PathVariable String email) {
        for (Estudent e : estudents) {

            if (e.getEmail().equalsIgnoreCase(email)) {
                return e;
            }

        }
        return null;
    }

    @PostMapping
    public Estudent postEstudent(@RequestBody Estudent estudent) {
        estudents.add(estudent);
        return estudent;
    }

    @PutMapping
    public Estudent putEstudent(@RequestBody Estudent estudent) {
        for (Estudent e : estudents) {
            if (e.getId() == estudent.getId()) {
                e.setName(estudent.getName());
                e.setEmail(estudent.getEmail());
                e.setAge(estudent.getAge());
                e.setCourse(estudent.getCourse());
                return e;
            }
        }
        return null;
    }

    @PatchMapping
    public Estudent patchEstudent(@RequestBody Estudent estudent) {
        for (Estudent e : estudents) {
            if (e.getId() == estudent.getId()) {
                if (estudent.getName() != null) {
                    e.setName(estudent.getName());
                }
                return e;
            }
        }
        return null;
    }

    @DeleteMapping({ "/{id}" })
    public Estudent deleteEstudent(@PathVariable int id) {
        for (Estudent e : estudents) {
            if (e.getId() == id) {
                estudents.remove(e);
                return e;
            }
        }
        return null;
    }
}
