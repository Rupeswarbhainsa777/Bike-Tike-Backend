# 🏍️ BikeCode — Bike Details Backend Web Application

A production-ready **RESTful API** built with **Java 21, Spring Boot 4, Spring Security, and MySQL** for managing comprehensive bike inventory and user data. This backend service is designed to be consumed by a React (or any) frontend application.

---

## 📌 Project Overview

**BikeCode** is a backend service that handles:

- Full **CRUD operations** for bike listing management
- **User registration** with persistent storage
- **Spring Security** with HTTP Basic Auth (stateless session)
- **JPA/Hibernate** auto-managed database schema
- **CORS** enabled for frontend integration

---

## 🚀 Tech Stack

| Technology                  | Version / Details                    |
|-----------------------------|--------------------------------------|
| **Java**                    | 21                                   |
| **Spring Boot**             | 4.0.1                                |
| **Spring Web MVC**          | REST API layer                       |
| **Spring Data JPA**         | ORM / Database abstraction           |
| **Hibernate**               | DDL auto-update                      |
| **Spring Security**         | HTTP Basic Auth, Stateless Sessions  |
| **MySQL**                   | Relational Database (`biketike` DB)  |
| **Lombok**                  | Boilerplate reduction                |
| **Maven**                   | Build & dependency management        |

---

## 📂 Project Structure

```
Bike/
├── src/
│   ├── main/
│   │   ├── java/com/code/Bike/
│   │   │   ├── BikeCodeApplication.java          # Main entry point
│   │   │   │
│   │   │   ├── Controller/
│   │   │   │   ├── AuthController.java           # User registration endpoint
│   │   │   │   └── BikeController.java           # Bike CRUD endpoints
│   │   │   │
│   │   │   ├── Service/
│   │   │   │   ├── BikeService.java              # Bike business logic
│   │   │   │   └── UserService.java              # User business logic
│   │   │   │
│   │   │   ├── Repository/
│   │   │   │   ├── BikeRepository.java           # Bike JPA repository
│   │   │   │   └── UserRepo.java                 # User JPA repository
│   │   │   │
│   │   │   ├── Model/
│   │   │   │   ├── Bike.java                     # Bike entity
│   │   │   │   ├── User.java                     # User entity
│   │   │   │   ├── BikeType.java                 # Enum: SPORTS, CRUISER, COMMUTER, ELECTRIC
│   │   │   │   ├── FuelType.java                 # Enum: PETROL, DIESEL, ELECTRIC, HYBRID
│   │   │   │   └── BikeStatus.java               # Enum: AVAILABLE, OUT_OF_STOCK, DISCONTINUED
│   │   │   │
│   │   │   ├── Filter/
│   │   │   │   └── JwtRequestFilter.java         # JWT filter (placeholder for future use)
│   │   │   │
│   │   │   └── config/
│   │   │       └── SecurityConfig.java           # Spring Security configuration
│   │   │
│   │   └── resources/
│   │       └── application.properties            # App config (DB, JPA, server)
│   │
│   └── test/
│       └── java/com/code/Bike/
│           └── BikeCodeApplicationTests.java     # Spring context load test
│
├── pom.xml                                       # Maven build configuration
├── mvnw / mvnw.cmd                               # Maven wrapper scripts
├── Readme.md                                     # Project documentation
└── .gitignore
```

---

## 🗄️ Database Configuration

The application connects to a **MySQL** database. Update `src/main/resources/application.properties` with your credentials:

```properties
spring.application.name=BikeCode
server.port=1002

# DATABASE
spring.datasource.url=jdbc:mysql://localhost:3306/biketike
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / HIBERNATE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

# SESSION
server.servlet.session.cookie.same-site=strict
```

> ⚠️ **Important:** Create the database schema manually before running the application:
> ```sql
> CREATE DATABASE biketike;
> ```
> Hibernate will auto-create/update tables via `ddl-auto=update`.

---

## 📐 Data Models

### Bike Entity (`bike` table)

| Field               | Type          | Description                              |
|---------------------|---------------|------------------------------------------|
| `id`                | Integer (PK)  | Auto-generated primary key               |
| `name`              | String        | Bike model name                          |
| `brand`             | String        | Manufacturer / brand                     |
| `image`             | String (1000) | Image URL or Base64 string               |
| `price`             | Long          | Price in currency units                  |
| `colour`            | String        | Bike colour                              |
| `mileage`           | String        | Mileage (e.g., "45 kmpl")               |
| `engineCc`          | Integer       | Engine displacement in CC                |
| `topSpeed`          | Integer       | Top speed in km/h                        |
| `transmission`      | String        | Manual / Automatic                       |
| `fuelTankCapacity`  | Integer       | Tank capacity in litres                  |
| `yearOfLaunch`      | Integer       | Year the bike was launched               |
| `bikeType`          | Enum          | `SPORTS`, `CRUISER`, `COMMUTER`, `ELECTRIC` |
| `fuelType`          | Enum          | `PETROL`, `DIESEL`, `ELECTRIC`, `HYBRID` |
| `status`            | Enum          | `AVAILABLE`, `OUT_OF_STOCK`, `DISCONTINUED` |

### User Entity (`tbl_user` table)

| Field       | Type      | Description                           |
|-------------|-----------|---------------------------------------|
| `id`        | Integer   | Auto-generated primary key            |
| `userId`    | String    | Unique user identifier                |
| `email`     | String    | User email address                    |
| `password`  | String    | User password                         |
| `role`      | String    | User role                             |
| `name`      | String    | Full name                             |
| `createdAt` | Timestamp | Auto-set on creation                  |
| `updatedAt` | Timestamp | Auto-updated on modification          |

---

## 🔌 API Endpoints

> **Base URL:** `http://localhost:1002`  
> **Authentication:** HTTP Basic Auth (Username: `user`, Password: `1234`) — required for all `/bike/**` endpoints.

### 🔐 Auth Endpoints

| Method | Endpoint     | Description              | Auth Required |
|--------|--------------|--------------------------|---------------|
| `POST` | `/user/reg`  | Register a new user      | ❌ No         |

**Request Body (`/user/reg`):**
```json
{
  "userId": "user001",
  "email": "user@example.com",
  "password": "securepassword",
  "role": "USER",
  "name": "John Doe"
}
```

---

### 🏍️ Bike Endpoints

| Method   | Endpoint            | Description              | Auth Required |
|----------|---------------------|--------------------------|---------------|
| `POST`   | `/bike/add`         | Add a new bike           | ✅ Yes        |
| `GET`    | `/bike/all`         | Get all bikes            | ✅ Yes        |
| `GET`    | `/bike/get/{id}`    | Get a bike by ID         | ✅ Yes        |
| `PUT`    | `/bike/update/{id}` | Update a bike by ID      | ✅ Yes        |
| `DELETE` | `/bike/delete/{id}` | Delete a bike by ID      | ✅ Yes        |

**Request Body (`/bike/add` and `/bike/update/{id}`):**
```json
{
  "name": "Apache RTR 160",
  "brand": "TVS",
  "image": "https://example.com/image.jpg",
  "price": 115000,
  "colour": "Matte Black",
  "mileage": "45 kmpl",
  "engineCc": 160,
  "topSpeed": 114,
  "transmission": "Manual",
  "fuelTankCapacity": 12,
  "yearOfLaunch": 2022,
  "bikeType": "SPORTS",
  "fuelType": "PETROL",
  "status": "AVAILABLE"
}
```

---

## 🔐 Security

The application uses **Spring Security** with the following configuration:

- **CSRF** is disabled (stateless API design)
- `/user/reg` is **publicly accessible** (no authentication)
- All other endpoints require **HTTP Basic Authentication**
- Session policy is **STATELESS**
- **Default in-memory credentials** (for development):
  - Username: `user`
  - Password: `1234`

> 🔒 **Note:** A `JwtRequestFilter` class is present as a placeholder for future JWT-based authentication. Replacing the in-memory auth with database-backed JWT is the recommended next step for production.

---

## ⚙️ Getting Started

### Prerequisites

- **Java 21** or higher installed
- **Maven 3.8+** installed (or use included `mvnw`)
- **MySQL 8+** running locally

### Installation & Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Rupeswarbhainsa777/Bike-Details-Backend-Web-Application.git
   cd Bike-Details-Backend-Web-Application
   ```

2. **Create the MySQL database:**
   ```sql
   CREATE DATABASE biketike;
   ```

3. **Update `application.properties`** with your MySQL credentials.

4. **Build and run the application:**
   ```bash
   # Using Maven wrapper (recommended)
   ./mvnw spring-boot:run

   # Or on Windows
   mvnw.cmd spring-boot:run

   # Or with Maven installed
   mvn spring-boot:run
   ```

5. **The API will be available at:**
   ```
   http://localhost:1002
   ```

---

## 🧪 Running Tests

```bash
./mvnw test
# or
mvnw.cmd test
```

---

## 🗺️ Enums Reference

### BikeType
```
SPORTS | CRUISER | COMMUTER | ELECTRIC
```

### FuelType
```
PETROL | DIESEL | ELECTRIC | HYBRID
```

### BikeStatus
```
AVAILABLE | OUT_OF_STOCK | DISCONTINUED
```

---

## 🔮 Roadmap / Future Enhancements

- [ ] Replace in-memory auth with **JWT-based authentication**
- [ ] Add **pagination and filtering** on `GET /bike/all`
- [ ] Add **search by brand, type, or fuel type**
- [ ] Integrate **Swagger/OpenAPI** documentation
- [ ] Add **role-based access control** (RBAC)
- [ ] Dockerize the application
- [ ] Deploy to cloud (AWS / GCP / Railway)

---

## 👨‍💻 Author

**Rupeswar Bhainsa**  
GitHub: [@Rupeswarbhainsa777](https://github.com/Rupeswarbhainsa777)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).