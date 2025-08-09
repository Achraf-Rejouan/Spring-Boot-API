package com.achrafrejouan.example.student;

import com.achrafrejouan.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {
        var newStudent = new Student();
        newStudent.setFirstName(dto.firstName());
        newStudent.setLastName(dto.lastName());
        newStudent.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        newStudent.setSchool(school);
        return newStudent;
    }

    public StudentResponseDto toResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
