# Students App (Product Management System)

A Spring Boot application for managing products with RESTful API endpoints.

## Project Description

This application provides a simple product management system with the following features:
- Store product information (name, price, quantity)
- Retrieve all products
- Retrieve a specific product by ID
- Search products by name
- Filter products by price

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web (REST)
- MySQL Database
- Maven
- Lombok

## Project Structure

```
students-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/yassinebek/studentsapp/
│   │   │       ├── entities/
│   │   │       │   └── Product.java
│   │   │       ├── reposotory/
│   │   │       │   └── ProductRepository.java
│   │   │       ├── web/
│   │   │       │   └── ProductController.java
│   │   │       └── StudentsAppApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/yassinebek/studentsapp/
│               └── StudentsAppApplicationTests.java
└── pom.xml
```

## Setup and Installation

### Prerequisites
- Java 21
- Maven
- MySQL Server

### Steps
1. Clone the repository
2. Configure MySQL database (default configuration in application.properties):
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/products-db?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=
   ```
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
   or
   ```
   java -jar target/students-app-0.0.1-SNAPSHOT.jar
   ```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /products | Get all products |
| GET | /products/{id} | Get product by ID |

### Additional Repository Methods (Not Exposed as API Endpoints Yet)

The repository includes the following query methods that could be exposed as API endpoints:
- `findByNameContains(String mc)`: Find products whose names contain a given string
- `search(String mc)`: Custom JPQL query to find products whose names match a pattern
- `findByPriceGreaterThan(double pr)`: Find products with prices greater than a specified value
- `searchByPrice(double pr)`: Custom JPQL query to find products with prices greater than a specified value

## Database Configuration

The application uses MySQL with the following configuration:
- Database URL: jdbc:mysql://localhost:3306/products-db
- Username: root
- Password: (empty)
- Hibernate DDL Auto: update (schema will be automatically updated)

## Future Enhancements

Potential enhancements for this project:
1. Add endpoints for creating, updating, and deleting products
2. Implement the search functionality as API endpoints
3. Add validation for product data
4. Implement pagination for product listing
5. Add authentication and authorization
6. Create a frontend interface