package com.example.student.StudentManagement.service;
import java.util.*;

import com.example.student.StudentManagement.dto.AddStudentRequestDTO;
import com.example.student.StudentManagement.dto.StudentDto;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDTO addStudentRequestDTO);
    
    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
