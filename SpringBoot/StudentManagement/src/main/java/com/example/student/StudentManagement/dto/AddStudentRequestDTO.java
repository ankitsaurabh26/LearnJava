package com.example.student.StudentManagement.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // @Data allows to see the fields (like name, email) clearly without scrolling through 100 lines of "getters and setters"
public class AddStudentRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be of length 3 to 30 characters")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
