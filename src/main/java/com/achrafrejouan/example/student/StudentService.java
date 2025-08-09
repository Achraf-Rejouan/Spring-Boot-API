package com.achrafrejouan.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        return repository.findAll().stream().map(studentMapper::toResponseDto).collect(Collectors.toList());
    }


    public StudentResponseDto findStudentById(Integer id) {
        return repository.findById(id).map(studentMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public List<StudentResponseDto> findStudentsByLastName(String lastName) {
        return repository.findAllByLastNameContaining(lastName).stream().map(studentMapper::toResponseDto).collect(Collectors.toList());
    }

    public void deleteStudent(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
