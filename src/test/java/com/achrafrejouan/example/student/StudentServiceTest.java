package com.achrafrejouan.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        StudentDto dto = new StudentDto(
                "John", "Doe", "jhon@gmail.com", 1
        );
        Student student = new Student(
                "John", "Doe", "jhon@gmail.com", 20
        );
        Student savedStudent = new Student(
                "John", "Doe", "jhon@gmail.com", 20
        );
        savedStudent.setId(1);
        StudentResponseDto expectedResponse = new StudentResponseDto(
                "John", "Doe", "jhon@gmail.com"
        );

        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toResponseDto(savedStudent)).thenReturn(expectedResponse);

        StudentResponseDto responseDto = studentService.saveStudent(dto);

        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toResponseDto(savedStudent);
    }

    @Test
    void testFindAllStudents() {
        // Create test data
        List<Student> students = List.of(
                new Student("John", "Doe", "john@gmail.com", 20),
                new Student("Jane", "Smith", "jane@gmail.com", 21)
        );

        List<StudentResponseDto> expectedResponses = List.of(
                new StudentResponseDto("John", "Doe", "john@gmail.com"),
                new StudentResponseDto("Jane", "Smith", "jane@gmail.com")
        );

        // Mock repository and mapper behavior
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toResponseDto(students.get(0))).thenReturn(expectedResponses.get(0));
        when(studentMapper.toResponseDto(students.get(1))).thenReturn(expectedResponses.get(1));

        // Call the service method
        List<StudentResponseDto> result = studentService.findAllStudents();

        // Verify the results
        assertEquals(2, result.size());
        assertEquals(expectedResponses, result);
        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(2)).toResponseDto(any(Student.class));
    }

    @Test
    void testFindStudentById() {
        // Arrange
        Integer StudentId = 1;
        Student student = new Student("John", "Doe", "john@gmail.com", 20);
        student.setId(StudentId);
        StudentResponseDto expectedResponse = new StudentResponseDto("John", "Doe", "john@gmail.com");

        when(studentRepository.findById(StudentId)).thenReturn(Optional.of(student));
        when(studentMapper.toResponseDto(student)).thenReturn(expectedResponse);

        // Act
        StudentResponseDto result = studentService.findStudentById(StudentId);

        // Assert
        assertEquals(expectedResponse.firstName(), result.firstName());
        assertEquals(expectedResponse.lastName(), result.lastName());
        assertEquals(expectedResponse.email(), result.email());
        verify(studentRepository).findById(StudentId);
        verify(studentMapper).toResponseDto(student);
    }

    @Test
    void testFindStudentById_NotFound() {
        // Arrange
        Integer StudentId = 1;
        when(studentRepository.findById(StudentId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> studentService.findStudentById(StudentId));
        assertEquals("Student not found with id: " + StudentId, exception.getMessage());
        verify(studentRepository).findById(StudentId);
        verify(studentMapper, never()).toResponseDto(any());
    }

}