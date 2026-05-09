
# QuizService
Spring Boot quiz microservice with JPA persistence, Feign-based question service integration, Eureka client support, and PostgreSQL backing.
=======
# quiz-service

A Spring Boot quiz microservice that creates quizzes, retrieves quiz questions, and calculates quiz results.

## Overview

`quiz-service` is a backend microsesrvice that:
- creates quizzes by category and number of questions
- stores quiz metadata using JPA
- retrieves quiz questions for a created quiz
- evaluates submitted quiz answers
- integrates with an external question service using Feign
- registers as an Eureka client

## Components

- `QuizController` - REST API endpoints
- `QuizService` - business logic for quiz creation, retrieval, and scorings
- `QuizDao` - JPA repository for quiz persistence
- `QuizInterface` - Feign client for requesting questions from an external service
- domain models: `Quiz`, `QuizDTO`, `QuestionWrapper`, `Response`

## Technologies

- Spring Boot 4.0.4
- Spring Web MVC
- Spring Data JPA
- Spring Cloud OpenFeign
- Spring Cloud Netflix Eureka Client
- PostgreSQL JDBC driver
- Lombok
- Maven
- Java 17

## API Endpoints

Base path: `/quiz`

- `POST /quiz/create`
  - Creates a quiz
  - Request body: `QuizDTO`
  - Response: `201 Created` with `Success`

- `GET /quiz/get/{id}`
  - Retrieves quiz questions by quiz ID
  - Response: `200 OK` with list of `QuestionWrapper`

- `POST /quiz/submit/{id}`
  - Submits quiz responses and calculates result
  - Request body: array of `Response`
  - Response: `200 OK` with score integer

## Requirements

- Java 17
- Maven
- PostgreSQL (configured in `application.properties`)
- External question service available for Feign calls
- Eureka server for service discovery if used in distributed mode

## Build and Run

```bash
mvn clean package
java -jar target/quiz-service-0.0.1-SNAPSHOT.jar
```

Or run from Maven:

```bash
mvn spring-boot:run ```

## Notes

- The service depends on an external question-service to generate quiz questions.
- The project currently uses JPA for persistence, so database configuration should be set in `src/main/resources/application.properties`.
- Ensure the application is properly registered with Eureka if service discovery is required.
>>>>>>> a973f74 (Initial commit)
