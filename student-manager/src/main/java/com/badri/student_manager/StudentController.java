package com.badri.student_manager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final studentservice service;

    public StudentController(studentservice service){
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable long id){
        Student student= service.getStudentById(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(student);
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student saved = service.addstudent(student);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delStudent(@PathVariable long id){
        service.delStudent(id);
        return ResponseEntity.ok("Student Deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable long id, @RequestBody Student updatedData){
        service.updateStudent(id,updatedData);

        if(updatedData == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Updated successfully");
    }
}
