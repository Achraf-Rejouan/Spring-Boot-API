package com.achrafrejouan.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto dto) {
        // Save the student to the repository
        var student = toStudent(dto);
        var savedStudent = repository.save(student);
        return toResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto dto) {
        var newStudent = new Student();
        newStudent.setFirstName(dto.firstName());
        newStudent.setLastName(dto.lastName());
        newStudent.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        newStudent.setSchool(school);
        return newStudent;
    }

    private StudentResponseDto toResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @GetMapping("/students/search/{lastName}")
    public List<Student> findStudentsByLastName(@PathVariable String lastName) {
        return repository.findAllByLastNameContaining(lastName);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

