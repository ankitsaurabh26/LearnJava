package com.example.student.StudentManagement.controller;

import com.example.student.StudentManagement.dto.AddStudentRequestDTO;
import com.example.student.StudentManagement.dto.StudentDto;
import com.example.student.StudentManagement.entity.Student;
import com.example.student.StudentManagement.repository.StudentRepository;
import com.example.student.StudentManagement.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class StudentController {

    // private final StudentRepository studentRepository;
    private final StudentService studentService;

    // StudentController(repository.StudentRepository studentRepository) {
    //     this.studentRepository = studentRepository;
    // }

    // // Creating the constructor: bean creation and DI
    // public StudentController(StudentRepository studentRepository){
    //     this.studentRepository = studentRepository;
    // }

    @GetMapping("/students")
    // public StudentDto getStudent() { // getStudent() is a function whose return type is StudentDto
    //     return new StudentDto(4L, "Ankit", "ankit@gmail.com");
    // }
    public List<StudentDto> getStudent(){
        // return studentRepository.findAll();
        return studentService.getAllStudents();
    }


    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    // @GetMapping("/students/{id}/{name}")
    // public String getStudentById(@PathVariable Long id, @PathVariable("name") String TheName){
    //     return "Path Variable is "+id + " and the name is "+TheName;
    // }

    // POST MAPPING
    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){ // ResponseEntity will give status code as well
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
    }

    // DELETE MAPPING
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    

    // PUT MAPPING
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDTO));

        // @RequestBody - takes the data sitting in the body of an HTTP request (usually JSON) and convert it automatically into a Java Object
    }

    // PATCH MAPPING
    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }

}