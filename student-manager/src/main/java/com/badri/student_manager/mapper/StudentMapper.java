package com.badri.student_manager.mapper;

import com.badri.student_manager.Entity.Student;
import com.badri.student_manager.dto.StudentRequest;
import com.badri.student_manager.dto.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public static Student toEntity(StudentRequest StudentDto){
        if(StudentDto == null){
            return null;
        }

        Student student = new Student();

        student.setName(StudentDto.name());
        student.setEmail(StudentDto.email());
        student.setBranch(StudentDto.branch());
        return student;
    }

    public static StudentResponse toResponseDto(Student student){
        if(student ==null){
            return null;
        }

       return new StudentResponse(
            student.getId(),
               student.getName(),
               student.getEmail(),
               student.getBranch()
        );

    }
}
