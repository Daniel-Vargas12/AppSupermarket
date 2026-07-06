# 🛒 AppSupermarket

API REST desarrollada con Java y Spring Boot para la gestión de un supermercado. Permite administrar sucursales, productos y ventas mediante una arquitectura por capas, utilizando PostgreSQL como base de datos y Docker para facilitar el despliegue.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Docker & Docker Compose
- Maven

---

##  Arquitectura del proyecto

El proyecto está organizado siguiendo una arquitectura por capas:

```
src/main/java
│
├── controller
├── service
├── repository
├── model
├── dto
├── Mapper
└── exception
```

Cada capa tiene una responsabilidad específica:

- **Controller:** expone los endpoints REST.
- **Service:** contiene la lógica de negocio.
- **Repository:** acceso a datos mediante Spring Data JPA.
- **Model:** entidades de la base de datos.
- **DTO:** objetos de transferencia de datos.
- **Mapper:** conversión entre entidades y DTOs.

---

##  Funcionalidades

- Gestión de sucursales.
- Gestión de productos.
- Registro de ventas.
- Gestión del detalle de cada venta.
- Persistencia de datos en PostgreSQL.
- Inicialización automática de datos mediante `data.sql`.

---

##  Modelo de datos

El proyecto utiliza las siguientes entidades:

- Sucursal
- Producto
- Venta
- DetalleVenta

---

##  Ejecución del proyecto

### Requisitos

- Docker Desktop
- Java 17 (opcional, solo para ejecutar desde el IDE)
- Maven (opcional)

### Clonar el repositorio

```bash
git clone https://github.com/Daniel-Vargas12/AppSupermarket.git

cd AppSupermarket
```

### Construir el proyecto

```bash
cd ejerciciosupermercado

mvn clean package

cd ..
```

### Levantar los contenedores

```bash
docker compose up --build
```

La aplicación quedará disponible en:

```
http://localhost:8080
```

---

##  Contenedores

El proyecto utiliza dos servicios:

- **Spring Boot**
- **PostgreSQL**

Docker Compose crea automáticamente:

- Base de datos `supermercado`
- Usuario `Support`
- Tablas mediante Hibernate
- Datos iniciales mediante `data.sql`

---

## 📌 Endpoints principales

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| GET | `/api/sucursales` | Listar sucursales |
| GET | `/api/productos` | Listar productos |
| GET | `/api/ventas` | Listar ventas |
| POST | `/api/ventas` | Registrar una venta |

> Los endpoints pueden probarse mediante Postman o cualquier cliente HTTP.

---

##  Características técnicas

- Arquitectura por capas.
- Uso de DTOs para desacoplar la API de las entidades.
- Mapper manual para conversión Entidad ↔ DTO.
- Persistencia mediante Spring Data JPA.
- Base de datos PostgreSQL.
- Contenedorización con Docker.

---

##  Autor

**Joan Daniel Vargas Avila**

GitHub: https://github.com/Daniel-Vargas12
