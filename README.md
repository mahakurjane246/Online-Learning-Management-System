🎓 Online Learning Management System
A Microservices-based Online Learning Management System developed using **Java, Spring Boot, Spring Cloud, Eureka Service Discovery, REST APIs, MySQL, Spring Data JPA, Hibernate, and Maven**.

The system is designed using a microservices architecture where each academic/business responsibility is separated into an independent service. Eureka Server provides service discovery across the platform, and each service exposes its own REST APIs backed by MySQL via Spring Data JPA and Hibernate.

## 📌 Project Overview

The Online Learning Management System provides a platform for managing:

👨‍🎓 Students 👨‍🏫 Instructors 📚 Courses 📋 Enrollments 📝 Assignments 📊 Results 💳 Payments

Instead of implementing the entire application as a single monolithic application, the system is divided into independent microservices, each with its own business responsibility, registered and discovered through Eureka.

## 🧩 Services

| Service | Responsibility |
|---|---|
| `eurekaserver` | Service registry & discovery |
| `student-service` | Student profile & account management |
| `instructor-service` | Instructor profile & course-ownership management |
| `course-service` | Course creation, catalog, and content management |
| `Enrollment-service` | Student-to-course enrollment management |
| `assignmentservice` | Assignment creation, submission, and tracking |
| `resultservice` | Grading and result management |
| `paymentservice` | Course fee/payment processing |

## 🎯 Project Objectives

- Build a complete microservices-based academic management application.
- Separate student, course, instructor, enrollment, assignment, result, and payment responsibilities into independent services.
- Implement service discovery using Eureka Server so services can locate one another without hard-coded IPs and ports.
- Provide REST APIs for CRUD operations across all academic and administrative entities.
- Use Spring Data JPA and Hibernate for clean, maintainable database access.
- Use MySQL for persistent, relational data storage.
- Demonstrate a complete online-learning workflow: enrollment → coursework → assignments → results → payments.
- Build a maintainable, layered backend using Spring Boot and Maven.

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot, Spring Cloud (Eureka)
- **Data Layer:** Spring Data JPA, Hibernate
- **Database:** MySQL
- **API Style:** REST
- **Build Tool:** Maven

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/mahakurjane246/Online-Learning-Management-System.git
   ```
2. Start `eurekaserver` first so other services can register with it.
3. Configure each service's `application.properties`/`application.yml` with your MySQL credentials.
4. Start the remaining services (`student-service`, `instructor-service`, `course-service`, `Enrollment-service`, `assignmentservice`, `resultservice`, `paymentservice`) in any order — they will register themselves with Eureka on startup.
5. Access each service's REST endpoints directly, or view registered instances on the Eureka dashboard (default: `http://localhost:8761`).

## 📄 License

This project is intended for educational/demonstration purposes.
