package com.achrafrejouan.example.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // This interface will automatically provide CRUD operations for the Student entity
    // No additional methods are needed unless custom queries are required

    // Example of a custom query method
    List<Student> findAllByLastNameContaining(String lastName);

}
