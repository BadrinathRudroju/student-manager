package com.badri.student_manager.Repository;

import com.badri.student_manager.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
