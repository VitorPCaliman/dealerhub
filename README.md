# DealerHub — Fullstack Customer Management

![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-3.x-blue?logo=quarkus&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-Latest-red?logo=angular&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-blue?logo=docker&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Planned-orange?logo=jsonwebtokens&logoColor=white)

DealerHub is a fullstack demo project created to practice and demonstrate real-world development patterns commonly used in corporate and enterprise environments.

The project simulates a Dealer / Customer Management system, focusing on clean architecture, modern frameworks, and best practices across backend, frontend, and infrastructure.

This repository is intentionally structured to reflect how a real production-ready system evolves step by step.


## PROJECT GOALS

- Practice Fullstack development using modern stacks
- Apply clean architecture and layering
- Implement REST APIs with Quarkus
- Integrate Angular frontend with a backend API
- Use Docker for local infrastructure
- Prepare a solid base for authentication and authorization
- Follow a clean Git Flow suitable for team environments


## CURRENT FEATURES (BASELINE)

BACKEND (QUARKUS)
- REST API built with Quarkus REST
- Customer CRUD:
  - Create customer
  - List customers
  - Delete customer
- Layered architecture:
  - Resource (Controller)
  - Service
  - Repository
  - Entity
  - DTOs
- Hibernate ORM with Panache
- PostgreSQL database
- Bean Validation
- OpenAPI / Swagger UI
- UUID-based identifiers
- Transactional service methods

FRONTEND (ANGULAR)
- Angular SPA (no SSR)
- Routing enabled
- CSS styling
- Ready for authentication and protected routes
- Prepared for API integration via HttpClient

INFRASTRUCTURE
- PostgreSQL running via Docker Compose
- Local development optimized for WSL (Linux environment)


## TECH STACK

BACKEND
- Java 17
- Quarkus 3
- Hibernate ORM + Panache
- PostgreSQL
- SmallRye OpenAPI
- Maven

FRONTEND
- Angular (latest)
- TypeScript
- CSS
- Node.js 20+

DEVOPS / TOOLING
- Docker & Docker Compose
- Git & GitHub
- WSL (Windows Subsystem for Linux)


## RUNNING THE PROJECT LOCALLY

PREREQUISITES
- Java 17
- Node.js 18+
- Docker & Docker Compose
- Maven
- Linux environment (WSL recommended)

START POSTGRESQL
cd docker
docker compose up -d

RUN BACKEND (QUARKUS)
cd backend
./mvnw quarkus:dev

Backend URL:
http://localhost:8080

Swagger UI:
http://localhost:8080/q/swagger-ui

RUN FRONTEND (ANGULAR)
cd frontend/app
npm start

Frontend URL:
http://localhost:4200


## API EXAMPLES

CREATE CUSTOMER
POST /customers
Content-Type: application/json

{
  "fullName": "John Doe",
  "email": "john.doe@email.com",
  "phone": "123456789"
}

LIST CUSTOMERS
GET /customers

DELETE CUSTOMER
DELETE /customers/{id}


## AUTHENTICATION (NEXT MILESTONE)

Authentication is intentionally not implemented yet.

Planned next steps:
- User management
- Password hashing
- JWT authentication
- Role-based access control
- Protected endpoints
- Angular login flow
- HTTP interceptor and route guards

This will be implemented following Git Flow using feature branches.


## GIT FLOW STRATEGY

Branching model:
- main      -> stable baseline
- develop   -> integration branch
- feature/* -> new features

Example:
main
 └── develop
       └── feature/auth-jwt


## DESIGN DECISIONS

- DTOs are used to avoid exposing persistence models
- UUIDs are preferred over numeric IDs for scalability
- Service layer isolates business logic
- Dockerized database ensures consistent environments
- No SSR since this is an authenticated business application


## LICENSE

This project is for educational and demonstration purposes.
