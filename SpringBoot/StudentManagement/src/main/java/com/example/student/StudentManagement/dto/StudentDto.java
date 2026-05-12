package com.example.student.StudentManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

    // // @AllArgsConstructor does the below thing for us
    // public StudentDto(Long id, String name, String email){
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }
}