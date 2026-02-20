# Recruitment Portal Backend

Spring Boot backend for a Recruitment Portal application.

## Tech Stack
- Java 17
- Spring Boot 4
- Spring Data JPA
- H2 In-Memory Database
- Maven

## Features Implemented
- Health check endpoint
- Create candidate (POST)
- Fetch all candidates (GET)
- Update candidate (PUT)
- H2 database integration

## API Endpoints

### Health Check
GET /health

### Create Candidate
POST /candidates
```json
{
  "name": "Charan",
  "email": "charan@example.com"
}
