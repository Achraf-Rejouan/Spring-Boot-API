package com.achrafrejouan.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        // Save the student to the repository
        return repository.save(student);
    }
}

