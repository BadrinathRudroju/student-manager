Student Manager API

A RESTful CRUD API for managing student records, built with Spring Boot and PostgreSQL.

Tech Stack

FrameworkSpring Boot 3.x
Language Java 17
Database PostgreSQL
ORM Spring Data JPA / Hibernate
Validation Spring Boot Validation (Bean Validation / Jakarta)
Build Tool Maven


Features

Create, Read, Update, and Delete student records

Bean Validation on all incoming request payloads

Global exception handling with meaningful error responses

PostgreSQL persistence via Spring Data JPA

It can check the students eligibilty to enter into the app using Jwt authentication

It has two databases user and Student because we can't add entry of the teacher into the student database, student database is only for the data of the each student 

