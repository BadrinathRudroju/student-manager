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

Project Structure
student-manager/
├── src/
│   └── main/
│       ├── java/com/example/studentmanager/
│       │   ├── controller/
│       │   │   └── StudentController.java
│       │   ├── service/
│       │   │   └── StudentService.java
│       │   ├── repository/
│       │   │   └── StudentRepository.java
│       │   ├── model/
│       │   │   └── Student.java
│       │   └── exception/
│       │       └── GlobalExceptionHandler.java
│       └── resources/
│           └── application.properties
└── pom.xml
