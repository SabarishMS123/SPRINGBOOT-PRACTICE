```markdown
<div align="center">

# ☕ Spring Boot & Enterprise Java Lab

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)

A structured monorepo demonstrating end-to-end backend engineering concepts, enterprise architecture patterns, REST API development, database relationships, and containerized deployments.

[Explore Repositories](https://github.com/SabarishMS123) • [Portfolio](https://sabarishdev.netlify.app/) • [Report Issue](https://github.com/SabarishMS123/SPRINGBOOT-PRACTICE/issues)

</div>

---

## 🧭 Repository Structure & Categorization

This repository contains hands-on enterprise modules categorized by architectural layer and functional focus.


```

SPRINGBOOT-PRACTICE/
├── 01-Core-Spring-Framework/      # IoC, DI, Bean Lifecycles, Scheduling
├── 02-Data-Persistence-JPA/       # JDBC, Hibernate, ORM Mappings, Pagination
├── 03-Security-Authentication/    # Spring Security, JWT, RBAC
├── 04-FullStack-Enterprise-Apps/  # E-Commerce, EMS, School Management Systems
└── 05-DevOps-Deployment/          # Docker, Tomcat, WAR/JAR packaging

```

---

## 🛠️ Module Index

<details open>
<summary><h3>1. Core Spring & Enterprise Utilities</h3></summary>

| Module / Directory | Key Concepts | Technologies |
|---|---|---|
| `SpringBootBeanClass-1, 2, 3` | Dependency Injection, IoC Container, Bean Scopes | Spring Boot Core |
| `SchedulingSpringBootclass2` | Cron expressions, `@Scheduled` automation | Spring Task Execution |
| `ExceptionHandling-1, 2` | `@ControllerAdvice`, `@ExceptionHandler`, standard error payloads | Spring Web |
| `FileHandling`, `FileManager...` | Multipart file upload, binary streaming, disk storage | Spring Web I/O |
| `Loggingconcept-useful-in-projects` | Logback, SLF4J log level management, diagnostic logging | SLF4J / Logback |
| `TransactionManagement-1` | ACID compliance, `@Transactional`, rollback boundaries | Spring TX |
| `Map_Entity_Using_ModelMapper` | DTO-to-Entity mapping, decoupling domain models | ModelMapper |

</details>

<details>
<summary><h3>2. Persistence, ORM & Database Architecture</h3></summary>

| Module / Directory | Key Concepts | Technologies |
|---|---|---|
| `JDBCMINE`, `Jdbcproject` | Raw JDBC connections, PreparedStatements, RowMappers | Java JDBC |
| `JPAConsoleCRUD`, `JPAProject` | Entity lifecycle, EntityManager, JPQL basics | JPA |
| `CrudMysqlApplication` | Standard REST CRUD with relational persistence | Spring Data JPA, MySQL |
| `One_to_Many_relationship` | `@OneToMany`, `@ManyToOne`, cascading, foreign key mapping | JPA / Hibernate |
| `Many_to_Many_relationship` | `@ManyToMany`, `@JoinTable`, junction table logic | JPA / Hibernate |
| `HibernateValidation`, `ValidationUsingHibernate` | Bean Validation (`@NotNull`, `@Size`, `@Pattern`), payload constraints | Jakarta / Hibernate Validator |
| `Pagination` | `Pageable`, `PageRequest`, sliced datasets for high-load APIs | Spring Data JPA |

</details>

<details>
<summary><h3>3. Security & Authentication Systems</h3></summary>

| Module / Directory | Key Concepts | Technologies |
|---|---|---|
| `JWT`, `JWT_FrontEnd`, `JWT_School` | Stateless token authentication, Claims parsing, Filter chains | Spring Security, JJWT |
| `SpringAuthentication` | Session handling, user credential evaluation | Spring Security Core |
| `Login_RegisterPage`, `LogingRegisterpage` | User authentication flows, password hashing | Spring Security, BCrypt |

</details>

<details>
<summary><h3>4. Full-Stack & Industry Systems</h3></summary>

| Module / Directory | Key Concepts | Tech Stack |
|---|---|---|
| `ElectionManagementSystem` | Voter registration, ballot processing, ballot integrity verification | Spring Boot, React, MySQL |
| `E-Commerce-Full-Stack-master` | Product catalogs, order lifecycle, shopping cart, payment workflows | Spring Boot, MySQL, REST API |
| `school-management-system` | Student enrolment, faculty mapping, course administration | Spring Boot, Thymeleaf, MySQL |
| `medicine-delivery-api` | Order tracking, inventory APIs, status pipelines | Spring Boot REST, JPA |
| `IMS-react-master` | Inventory lifecycle, stock balance tracking, supplier integrations | React, Spring Boot |
| `audio-transcriber` | Audio ingestion, file processing, transcription integration | Spring Boot, Speech API |

</details>

<details>
<summary><h3>5. Containerization, DevOps & Packaging</h3></summary>

| Module / Directory | Key Concepts | Execution |
|---|---|---|
| `Docker`, `Docker-1, 2, 3` | Containerized Java environments, multi-stage builds | Docker, Dockerfile |
| `DockerFileproject-2` | Spring Boot image optimization and runtime flags | Alpine JRE, Docker |
| `JARWARpackagingdeployment` | Standalone executable JAR vs Servlet container WAR builds | Maven / Gradle |
| `apache-tomcat-10.1.54` | Servlet container setup, WAR artifact deployment | Apache Tomcat 10 |

</details>

---

## ⚡ Quick Start

### Prerequisites
* **JDK:** OpenJDK 17 or higher
* **Build Tool:** Maven 3.8+ / Gradle
* **Database:** MySQL Server 8.0+
* **Container Engine:** Docker Desktop

### Running an Individual Module

```bash
# 1. Clone the repository
git clone [https://github.com/SabarishMS123/SPRINGBOOT-PRACTICE.git](https://github.com/SabarishMS123/SPRINGBOOT-PRACTICE.git)

# 2. Navigate to your desired project directory
cd SPRINGBOOT-PRACTICE/CrudMysqlApplication

# 3. Configure your database connection in application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/your_db
# spring.datasource.username=root
# spring.datasource.password=your_password

# 4. Build and execute via Maven Wrapper
./mvnw clean spring-boot:run

```

## 👨‍💻 Author

**Sabarish M S**

* Salem, Tamil Nadu, India
* **GitHub:** [@SabarishMS123](https://www.google.com/url?sa=E&source=gmail&q=https://github.com/SabarishMS123)
* **Portfolio:** [sabarishdev.netlify.app](https://sabarishdev.netlify.app/)

---

© All rights reserved.

```

```
