# Reservation Backend

Sistema de gestión de reservaciones construido con Java Spring Boot y Maven.

## Descripción

Este proyecto es un backend de reservaciones que proporciona una API REST para crear, consultar, actualizar y cancelar reservaciones. Utiliza una arquitectura de capas con controladores, servicios, repositorios y entidades.

## Requisitos Previos

- Java 11 o superior
- Maven 3.6+
- Base de datos (configurada en `application.properties`)

## Estructura del Proyecto

```
reservation-backend/
├── src/
│   ├── main/
│   │   ├── java/com/uniguajira/ijesusmartinez/reservation_backend/
│   │   │   ├── controller/      # REST Controllers
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # JPA Entities
│   │   │   ├── exception/        # Custom Exceptions
│   │   │   ├── mapper/           # Entity-DTO Mappers
│   │   │   ├── repository/       # JPA Repositories
│   │   │   └── service/          # Business Logic
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/                 # Tests
└── pom.xml
```

## Instalación

1. **Clonar el repositorio**

   ```bash
   git clone <repository-url>
   cd FullStack/reservation-backend
   ```

2. **Compilar el proyecto**

   ```bash
   mvn clean compile
   ```

3. **Ejecutar tests**

   ```bash
   mvn test
   ```

4. **Empaquetar la aplicación**
   ```bash
   mvn package
   ```

## Uso

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación se ejecutará en `http://localhost:8080`

### Endpoints principales

- `POST /api/reservations` - Crear una nueva reservación
- `GET /api/reservations/{id}` - Obtener una reservación por ID
- `GET /api/reservations` - Listar todas las reservaciones
- `PUT /api/reservations/{id}` - Actualizar una reservación
- `DELETE /api/reservations/{id}` - Cancelar una reservación

## Configuración

Editar el archivo `src/main/resources/application.properties` para configurar:

- Conexión a base de datos
- Puerto del servidor
- Logging
- Otras propiedades de la aplicación

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/reservations
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

## Tecnologías Utilizadas

- **Java 11+** - Lenguaje de programación
- **Spring Boot** - Framework web
- **Spring Data JPA** - Acceso a datos
- **Maven** - Gestor de dependencias
- **MySQL/Postgres** - Base de datos (configurable)

## Contribuir

Para contribuir a este proyecto:

1. Fork el repositorio
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

## Autor

**Ijesús Martínez**

- Universidad de La Guajira

## Contacto

Para preguntas o sugerencias, contáctanos a través del repositorio.
