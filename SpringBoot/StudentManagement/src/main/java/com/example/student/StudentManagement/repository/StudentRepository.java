package com.example.student.StudentManagement.repository;
import com.example.student.StudentManagement.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
}
// Even though the curly braces { } are empty, your interface is not empty—it has inherited everything from its parent.
