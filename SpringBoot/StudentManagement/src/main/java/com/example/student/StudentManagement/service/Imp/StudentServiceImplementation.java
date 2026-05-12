package com.example.student.StudentManagement.service.Imp;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.student.StudentManagement.dto.AddStudentRequestDTO;
import com.example.student.StudentManagement.dto.StudentDto;
import com.example.student.StudentManagement.entity.Student;
import com.example.student.StudentManagement.repository.StudentRepository;
import com.example.student.StudentManagement.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentDtoList = students.stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: "+id));
        // We will use modelMapper library to convert Student to StudentDto: the library name is ModelMapper
        return modelMapper.map(student, StudentDto.class); // .map(source, destination)
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDTO addStudentRequestDTO){
        Student newStudent = modelMapper.map(addStudentRequestDTO, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: "+id));
        modelMapper.map(addStudentRequestDTO, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: "+id));
        updates.forEach((String field,Object value)->{
            switch(field){
                case "name": 
                    student.setName((String)value);
                    break;
                case "email": 
                    student.setEmail((String)value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not valid");
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }

}
