package com.badri.student_manager.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "It should have a name")
    @Size(min = 2, max = 50, message= "It should be betweeen 2 to 50 characters")
    private String name;

    @NotBlank(message = "It should have mail")
    @Email(message = "email must be valid")
    private String email;

    @Min(value = 1, message = "age should be atleast 1")
    @Max(value = 100, message ="age should not exceed 100")
    private String branch;

    public Student(){
    }

    public Student(String name, String email, String branch){
        this.name= name;
        this.email = email;
        this.branch = branch;
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }


    public void setBranch(String branch){
        this.branch = branch;
    }
    public String getBranch(){
        return this.branch;
    }

}
