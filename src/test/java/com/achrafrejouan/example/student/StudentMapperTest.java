package com.achrafrejouan.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
     public void testToStudent() {
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "jhon@mail.com",
                1
        );
        Student student = studentMapper.toStudent(dto);
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
     }

    @Test
    public void testToResponseDto() {
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setEmail("jane@gmail.com");
        student.setAge(20);
        StudentResponseDto responseDto = studentMapper.toResponseDto(student);
        assertEquals(student.getFirstName(), responseDto.firstName());
        assertEquals(student.getLastName(), responseDto.lastName());
        assertEquals(student.getEmail(), responseDto.email());
        assertNotNull(responseDto);
    }
}