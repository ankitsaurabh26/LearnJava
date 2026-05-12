package com.example.student.StudentManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType; 


@Entity
@Getter
@Setter
public class Student {
    @Id // The @Id annotation tells JPA/Hibernate: "This specific field is the Primary Key."
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
}
