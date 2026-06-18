package com.badri.student_manager.service;

import com.badri.student_manager.Entity.Student;
import com.badri.student_manager.Repository.StudentRepository;
import com.badri.student_manager.dto.StudentRequest;
import com.badri.student_manager.dto.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    private final StudentRepository repository;


    public studentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<StudentResponse> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id){
       Student student = repository.findById(id)
               .orElse(null);
        assert student != null;
        return toResponse(student);
    }

    public StudentResponse addstudent(Student request){
        Student student = new Student();
        student.setName(request.getName());
        student.setBranch(request.getBranch());
        student.setEmail(request.getEmail());

        Student saved = repository.save(student);
        return toResponse(saved);
    }

    public void delStudent(long id){
        repository.deleteById(id);
    }

    public StudentResponse updateStudent(long id, StudentRequest updatedData){
        Student existing =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found"));

        existing.setName(updatedData.name());
        existing.setBranch(updatedData.branch());
        existing.setEmail(updatedData.email());
        Student updated = repository.save(existing);

        return toResponse(updated);
    }

    public StudentResponse toResponse(Student student){
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getBranch()
        );
    }
}
