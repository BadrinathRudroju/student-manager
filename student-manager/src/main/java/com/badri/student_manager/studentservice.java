package com.badri.student_manager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentservice {
    private final StudentRepository repository;

    public studentservice(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student getStudentById(long id){
        return repository.findById(id).
                orElse(null);
    }

    public Student addstudent(Student student){
        return repository.save(student);
    }

    public void delStudent(long id){
        repository.deleteById(id);
    }
}
