package com.badri.student_manager.Controller;

import com.badri.student_manager.Entity.Student;
import com.badri.student_manager.dto.StudentRequest;
import com.badri.student_manager.dto.StudentResponse;
import com.badri.student_manager.service.studentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final studentService service;

    public StudentController(studentService service){
        this.service = service;
    }

    @GetMapping
    public List<StudentResponse> getAll(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable long id){
            return ResponseEntity.ok(service.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addstudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delStudent(@PathVariable long id){
        service.delStudent(id);
        return ResponseEntity.ok("Student Deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable long id,
                                                @RequestBody StudentRequest updatedData){


        return ResponseEntity.ok(service.updateStudent(id,updatedData));
    }
}
