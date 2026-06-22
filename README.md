# Student Manager API

A production-ready RESTful API for comprehensive student record management, built with Spring Boot and PostgreSQL. This service provides secure, validated CRUD operations with role-based access control through JWT authentication.

## Overview

The Student Manager API is designed to streamline educational institution workflows by providing a robust backend service for managing student data. The system enforces strict data separation between student records and user authentication credentials, ensuring data integrity and security across multiple organizational roles.

## Tech Stack

| Component | Technology |
|-----------|-----------|
| **Framework** | Spring Boot 3.x |
| **Language** | Java 17 |
| **Database** | PostgreSQL |
| **ORM** | Spring Data JPA / Hibernate |
| **Validation** | Spring Boot Validation (Bean Validation / Jakarta) |
| **Authentication** | JWT (JSON Web Tokens) |
| **Build Tool** | Maven |
| **Containerization** | Docker |

## Features

### Core Functionality
- **Complete CRUD Operations**: Create, Read, Update, and Delete student records with full audit trails
- **Request Validation**: Comprehensive Bean Validation on all incoming payloads with detailed error messages
- **Global Exception Handling**: Centralized error handling with meaningful, consistent API responses
- **Data Persistence**: Reliable PostgreSQL integration via Spring Data JPA with Hibernate ORM

### Security & Access Control
- **JWT Authentication**: Secure endpoint access with token-based authentication
- **Role-Based Access Control**: Differentiated user roles for students, teachers, and administrators
- **Separation of Concerns**: Distinct user and student databases preventing unauthorized cross-role data access

### Architecture
- **Dual Database Schema**: 
  - User database for authentication and role management
  - Student database for academic records and student-specific data
  - This separation ensures teachers and other roles cannot be registered as students

## Getting Started

### Prerequisites
- Java 17 or higher
- PostgreSQL 12 or higher
- Maven 3.8 or higher
- Docker (optional, for containerized deployment)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/BadrinathRudroju/student-manager.git
   cd student-manager
   ```

2. **Configure database**
   - Create PostgreSQL databases for users and students
   - Update `application.properties` or `application.yml` with database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080`

### Docker Deployment

```bash
docker build -t student-manager:latest .
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/student_db \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=password \
  student-manager:latest
```

## API Documentation

### Authentication

Obtain a JWT token by authenticating with valid credentials. Include the token in subsequent requests:

```bash
Authorization: Bearer <your_jwt_token>
```

### Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/api/students` | List all students | Yes |
| GET | `/api/students/{id}` | Get student details | Yes |
| POST | `/api/students` | Create new student | Yes |
| PUT | `/api/students/{id}` | Update student record | Yes |
| DELETE | `/api/students/{id}` | Delete student record | Yes |

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/studentmanager/
│   │       ├── controller/      # REST endpoints
│   │       ├── service/         # Business logic
│   │       ├── repository/      # Data access layer
│   │       ├── entity/          # JPA entities
│   │       ├── dto/             # Data transfer objects
│   │       ├── exception/       # Custom exceptions
│   │       ├── validation/      # Validation logic
│   │       └── config/          # Application configuration
│   └── resources/
│       └── application.properties
└── test/
    └── java/                    # Unit and integration tests
```

## Configuration

Key application properties:

```properties
# Server
server.port=8080

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# JWT
jwt.secret=your_secret_key_here
jwt.expiration=86400000
```

## Error Handling

The API returns standardized error responses:

```json
{
  "timestamp": "2024-01-15T10:30:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed: Email format is invalid",
  "path": "/api/students"
}
```

## Development

### Running Tests

```bash
mvn test
```

### Code Quality

Ensure code follows best practices:
- Use consistent formatting with Maven Checkstyle
- Write unit tests for business logic
- Document public APIs and complex logic

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues, questions, or suggestions, please open an [issue](https://github.com/BadrinathRudroju/student-manager/issues) on GitHub.

## Roadmap

- [ ] Advanced filtering and pagination for student records
- [ ] Export student data to CSV/Excel
- [ ] Email notifications for student enrollment
- [ ] Student performance analytics dashboard
- [ ] Multi-tenant support for multiple institutions

---

**Last Updated**: June 2024  
**Maintained By**: BadrinathRudroju
