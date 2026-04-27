package com.badri.student_manager;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
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
