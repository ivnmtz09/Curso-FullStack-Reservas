# Reservas Pro — Full-Stack Reservation System

A modern, full-stack reservation management system built with **Spring Boot** (backend) and **Angular 21** (frontend). The application allows users to create, view, and cancel reservations with a responsive, dark-themed UI.

---

## Architecture

```
FullStack/
├── reservation-backend/   # Spring Boot REST API (Java 25)
└── reservation-frontend/  # Angular 21 SPA (standalone components)
```

The frontend communicates with the backend via RESTful HTTP calls. CORS is configured to allow requests from `http://localhost:4200`.

---

## Backend — `reservation-backend/`

Java 25 + Spring Boot 4.0 REST API with PostgreSQL persistence.

### Tech Stack

- **Java 25** — Latest Java LTS
- **Spring Boot 4.0** — Web MVC, Data JPA, DevTools
- **PostgreSQL** — Relational database
- **SpringDoc OpenAPI 3.0** — API documentation (Swagger UI at `/swagger-ui.html`)
- **Maven** — Build and dependency management

### API Endpoints

| Method | Endpoint                    | Description            |
|--------|-----------------------------|------------------------|
| `POST`   | `/api/reservations`         | Create a reservation   |
| `GET`    | `/api/reservations`         | List all reservations  |
| `DELETE` | `/api/reservations/{id}`    | Cancel a reservation   |

### Layers

```
controller/    → REST endpoints
dto/           → Request/response DTOs
entity/        → JPA entities
exception/     → Custom exception handling
mapper/        → Entity ↔ DTO mapping
repository/    → Spring Data JPA repositories
service/       → Business logic
```

---

## Frontend — `reservation-frontend/`

Angular 21 single-page application with standalone components, signals, and reactive forms.

### Tech Stack

- **Angular 21** — Latest Angular with standalone component architecture
- **Angular Signals** — Reactive state management (no NgRx)
- **Reactive Forms** — Form validation and submission
- **RxJS** — HTTP communication and observables
- **TypeScript 5.9** — Strict mode
- **pnpm** — Fast, disk-efficient package manager
- **Vitest** — Unit testing

### Pages

| Route   | Component                 | Description                    |
|---------|---------------------------|--------------------------------|
| `/`       | `HomeComponent`           | Landing page with hero section |
| `/list`   | `ReservationListComponent`| View & cancel reservations     |
| `/create` | `ReservationCreateComponent` | New reservation form        |

### Component Architecture

```
App (app.component.ts)
├── RouterOutlet
│   ├── HomeComponent        (/)        → navigation hub
│   ├── ReservationList      (/list)    → ReservationService
│   └── ReservationCreate    (/create)  → ReservationService + ToastService
└── ToastComponent (global)             → ToastService
```

---

## Prerequisites

- **Java 25** (or 21+) — [Download](https://adoptium.net/)
- **Maven 3.9+** — [Download](https://maven.apache.org/download.cgi)
- **Node.js 22+** — [Download](https://nodejs.org/)
- **pnpm** — `npm install -g pnpm`
- **PostgreSQL** — Running instance (or configure another DB)

---

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd FullStack
```

### 2. Backend setup

```bash
cd reservation-backend
```

Edit `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reservations
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8081
```

Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at `http://localhost:8081/api`.

### 3. Frontend setup

```bash
cd reservation-frontend
pnpm install
pnpm start
```

The app will be available at `http://localhost:4200`.

---

## Running Tests

### Backend

```bash
cd reservation-backend
mvn test
```

### Frontend

```bash
cd reservation-frontend
pnpm test
```

---

## Configuration

### Backend (`application.properties`)

| Property | Description | Default |
|----------|-------------|---------|
| `spring.datasource.url` | Database JDBC URL | `jdbc:postgresql://localhost:5432/reservations` |
| `spring.datasource.username` | Database user | `postgres` |
| `spring.datasource.password` | Database password | — |
| `server.port` | Server port | `8081` |
| `spring.jpa.hibernate.ddl-auto` | Schema generation | `update` |

### Frontend (`src/environments/`)

| Environment | `baseUrl` |
|-------------|-----------|
| Development | `http://localhost:8081/api` |
| Production  | `https://api.example.com/api` |

---

## Project Structure

```
FullStack/
├── reservation-backend/
│   ├── src/main/java/com/uniguajira/ijesusmartinez/reservation_backend/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── mapper/
│   │   ├── repository/
│   │   └── service/
│   ├── src/main/resources/application.properties
│   └── pom.xml
│
├── reservation-frontend/
│   ├── src/app/
│   │   ├── component/
│   │   │   ├── home/
│   │   │   ├── reservation-create/
│   │   │   ├── reservation-list/
│   │   │   └── toast/
│   │   ├── model/
│   │   ├── service/
│   │   ├── app.ts
│   │   ├── app.config.ts
│   │   └── app.routes.ts
│   ├── angular.json
│   ├── package.json
│   └── tsconfig*.json
│
└── README.md
```

---

## API Documentation

Once the backend is running, Swagger UI is available at:

```
http://localhost:8081/swagger-ui.html
```

---

## Built With

| Backend | Frontend |
|---------|----------|
| Java 25 | Angular 21 |
| Spring Boot 4.0 | Angular Signals |
| Spring Data JPA | Reactive Forms |
| PostgreSQL | TypeScript 5.9 |
| SpringDoc OpenAPI | RxJS |
| Maven | pnpm, Vitest |

---

## Author

**Ijesús Martínez** — Universidad de La Guajira

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
