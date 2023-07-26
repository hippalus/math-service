# Math Service Application

The Math Service Application is a RESTful web service that calculates the smallest positive number that can be divided by a
sequential range of numbers (from 1 to N) without remainder.

## Architecture and Design Choices

This application was built using several architectural and design principles to ensure maintainability, extensibility,
and testability.

- **Spring Boot**: The application is implemented using Spring Boot, a popular Java framework for building robust and
  scalable applications.
- **Domain-Driven Design (DDD) and Clean Architecture**: The application follows DDD principles to separate concerns and
  create a loosely coupled architecture. The domain interfaces are defined separately to decouple the application from
  specific infrastructure implementations.
- **Separation of Models**: The application separates API models, domain models, and database models. This separation
  allows for flexibility and modularity, as each layer can have its own specific requirements and structures.

# Solution Approach

The solution implements a Spring Boot application with two REST controllers. The application leverages the concept of Least
Common Multiple (LCM) and Greatest Common Divisor (GCD) to efficiently calculate the smallest number satisfying the given
conditions.

# LCM (Least Common Multiple)

LCM is the smallest positive number that is divisible by two or more given numbers without any remainder. It is used in the
calculate function to find the smallest number divisible by a sequential range of numbers.

# GCD (Greatest Common Divisor)

GCD is the largest positive integer that divides two or more given numbers without leaving any remainder. It is used within the
lcm function to calculate the LCM of two numbers.

## Overview

The application is built with Kotlin and Spring Boot. It uses Spring Controllers to expose RESTful endpoints for setting the upper
number to check and for calculating the smallest number that satisfies the criteria. The application leverages caching with Spring
Cache to optimize performance.

## Prerequisites

Before running the application, make sure you have the following software installed on your system:

- Java 17 or higher
- Maven (if building from source)
- Docker

## How to Run the Application

To run the application, please follow these steps:

1. Clone the repository and ensure that Docker is installed and running on your machine.

 ```bash
git clone https://github.com/hippalus/math-service.git
```

2. Navigate to the project directory by executing the following command in your terminal or command prompt:

```bash
cd math-service/
```

3. Run the following command to start the application using Docker Compose:

```bash
docker-compose up
```

## API Documentation

The API is thoroughly documented using OpenAPI. The documentation provides details about each endpoint, including
request and response formats, parameters, and example usage. To access the API documentation, please follow these steps:

1. Start the application by following the instructions mentioned in the previous section.
2. To access Swagger UI, open your web browser and go to [Swagger UI](http://localhost:8080/swagger-ui.html).
3. The API documentation page will be displayed, allowing you to explore the available endpoints and interact with the
   API.

## Testing

The application includes both unit tests and integration tests to ensure the correctness of the implemented
functionality. The tests cover different scenarios and edge cases to validate the behavior of the code.

```bash
./mvnw clean test
```