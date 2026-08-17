# API Management

A Spring Boot REST API application for user management with AWS API Gateway integration.

## Overview

This project provides CRUD (Create, Read, Update, Delete) operations for managing users. The application is developed using Spring Boot and exposed through AWS API Gateway.
## Architecture

The application follows a layered architecture:

Client (Postman / Swagger UI)
|
v
Spring Boot REST API
|
v
UserController
|
v
UserRepository
|
v
MySQL Database

Detailed architecture is available in:
docs/architecture-diagram.png

## Tech Stack

- Java
- Spring Boot
- Maven
- REST API
- AWS API Gateway

## Project Structure

Api_Management
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

## Features

- Create User
- Retrieve Users
- Update User
- Delete User
- Global Exception Handling
- RESTful API Design
- AWS API Gateway Integration

## API Endpoints

### Get All Users

http
GET /

### Create User

http
POST /

Sample Request:

json
{
  "name": "John Doe",
  "email": "john@example.com"
}

### Update User

http
PUT /{id}


Sample:

http
PUT /1


### Delete User

http
DELETE /{id}

Sample:

http
DELETE /1

## AWS API Gateway Configuration

API Name:
api_Management


Configured Resources:
/
├── GET
├── POST
└── /{id}
    ├── PUT
    └── DELETE

### Architecture

Client
   │
   ▼
AWS API Gateway
   │
   ▼
Spring Boot Application
   │
   ▼
Data Layer

## Build and Run

### Clone Repository

bash
git clone <repository-url>
cd Api_Management
### Build Application

bash
mvn clean install

### Run Application

bash
mvn spring-boot:run


Application starts on:

http://localhost:8082
## Testing APIs

You can test the APIs using:

- Postman
- Swagger (if configured)
- AWS API Gateway Test Console
- cURL

Example:

bash
curl -X GET http://localhost:8082/


## Exception Handling

Custom exceptions included:

- ResourceNotFoundException
- DuplicateResourceException
- GlobalExceptionHandler

## Future Enhancements

- Database Integration (MySQL/PostgreSQL)
- AWS Lambda Integration
- Authentication & Authorization
- Swagger/OpenAPI Documentation
- CI/CD Pipeline
- Docker Support

## Author
Manikanta Sriramoju
