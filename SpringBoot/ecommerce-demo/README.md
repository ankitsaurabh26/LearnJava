# 🛒 E-Commerce Product Catalog Backend

> **A production-ready Spring Boot REST API** for managing an e-commerce product catalog — built with clean architecture, proper layering, and best practices.

---

## 📋 Table of Contents

- [Tech Stack](#tech-stack)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Key Design Decisions](#key-design-decisions)
- [Sample API Calls](#sample-api-calls)

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 21 (LTS) | Programming language |
| Spring Boot | 3.2.5 | Application framework |
| Spring Data JPA | 3.2.5 | Database ORM layer |
| Hibernate | 6.x | JPA implementation |
| MySQL | 8.x | Relational database |
| Lombok | Latest | Boilerplate code reduction |
| Maven | 3.9+ | Build & dependency management |

---

## 🏗️ Architecture Overview

This project follows the **Layered Architecture** pattern — the industry standard for Spring Boot applications.

```
                        HTTP Request
                             │
                             ▼
            ┌─────────────────────────────┐
            │       CONTROLLER LAYER       │  ← Receives requests, sends responses
            │  ProductController           │    No business logic here!
            │  CategoryController          │
            └──────────────┬──────────────┘
                           │ calls
                           ▼
            ┌─────────────────────────────┐
            │        SERVICE LAYER         │  ← All business logic lives here
            │  ProductService              │    Validation, transformations,
            │  CategoryService             │    orchestration
            └──────────────┬──────────────┘
                           │ calls
                           ▼
            ┌─────────────────────────────┐
            │      REPOSITORY LAYER        │  ← Database communication
            │  ProductRepository           │    Spring Data JPA handles SQL
            │  CategoryRepository          │
            └──────────────┬──────────────┘
                           │ queries
                           ▼
            ┌─────────────────────────────┐
            │          MySQL DB            │
            │   products | categories      │
            └─────────────────────────────┘
```

### Data Flow (Request Lifecycle)

```
Client → Controller → Service → Repository → MySQL
                                               │
Client ← Controller ← Service ← Repository ←──┘
        (ApiResponse)  (DTO)    (Entity)
```

**Why DTOs?** We never expose raw database entities directly to the client. DTOs (Data Transfer Objects) let us control exactly what data goes in and out — a critical security and design practice.

---

## 📁 Project Structure

```
ecommerce-demo/
├── pom.xml                          # Maven dependencies & build config
│
└── src/
    ├── main/
    │   ├── java/com/demo/ecommerce/
    │   │   │
    │   │   ├── EcommerceApplication.java     # 🚀 Main entry point
    │   │   │
    │   │   ├── model/                        # 📦 JPA Entities (DB tables)
    │   │   │   ├── Product.java
    │   │   │   └── Category.java
    │   │   │
    │   │   ├── dto/                          # 📨 Data Transfer Objects
    │   │   │   ├── ProductDTO.java           #    Request & Response shapes
    │   │   │   ├── CategoryDTO.java
    │   │   │   └── ApiResponse.java          #    Standard API response wrapper
    │   │   │
    │   │   ├── repository/                   # 🗄️  Database operations
    │   │   │   ├── ProductRepository.java
    │   │   │   └── CategoryRepository.java
    │   │   │
    │   │   ├── service/                      # ⚙️  Business logic
    │   │   │   ├── ProductService.java
    │   │   │   └── CategoryService.java
    │   │   │
    │   │   ├── controller/                   # 🌐 REST API endpoints
    │   │   │   ├── ProductController.java
    │   │   │   └── CategoryController.java
    │   │   │
    │   │   ├── exception/                    # ❌ Error handling
    │   │   │   ├── ResourceNotFoundException.java
    │   │   │   └── GlobalExceptionHandler.java
    │   │   │
    │   │   └── config/                       # ⚙️  Configuration
    │   │       └── DataSeeder.java           #    Auto-loads sample data
    │   │
    │   └── resources/
    │       └── application.properties        # App & DB configuration
    │
    └── test/
        └── java/com/demo/ecommerce/
            └── EcommerceApplicationTests.java
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21+ installed (`java -version` to check)
- Maven 3.9+ installed (`mvn -version` to check)
- MySQL 8.x running locally

### Step 1: Database Setup

```sql
-- MySQL mein yeh run karo (already auto-create hoga, but manual bhi kar sakte ho)
CREATE DATABASE IF NOT EXISTS ecommerce_db;
```

### Step 2: Configure Database

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE   # ← Yahan apna password daalo
```

### Step 3: Build & Run

```bash
# Project folder mein jao
cd ecommerce-demo

# Dependencies download karo aur project build karo
mvn clean install

# Application start karo
mvn spring-boot:run
```

### Step 4: Verify It's Running

You should see this in the console:
```
===========================================
  E-Commerce Backend chal gaya! 🎉
  URL: http://localhost:8080/api
===========================================
```

The app auto-seeds **4 categories** and **9 products** on first run — ready to demo immediately!

---

## 📡 API Reference

### Base URL: `http://localhost:8080/api`

### Standard Response Format

Every API response follows the same structure:

```json
{
  "success": true,
  "message": "Human readable message",
  "data": { ... },
  "timestamp": "2024-01-15T10:30:00"
}
```

---

### 📦 Products API

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/products` | Create a new product |
| `GET` | `/api/products` | Get all products (paginated) |
| `GET` | `/api/products/{id}` | Get product by ID |
| `PUT` | `/api/products/{id}` | Update full product |
| `DELETE` | `/api/products/{id}` | Soft delete product |
| `GET` | `/api/products/search?name=phone` | Search by name |
| `GET` | `/api/products/category/{id}` | Products by category |
| `GET` | `/api/products/price-range?minPrice=100&maxPrice=5000` | Filter by price |
| `GET` | `/api/products/low-stock?threshold=5` | Low stock alert |
| `PATCH` | `/api/products/{id}/stock?quantity=50` | Update stock only |

### 🗂️ Categories API

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/categories` | Create a new category |
| `GET` | `/api/categories` | Get all categories |
| `GET` | `/api/categories/{id}` | Get category by ID |
| `PUT` | `/api/categories/{id}` | Update category |
| `DELETE` | `/api/categories/{id}` | Delete category |

---

## 💡 Sample API Calls

Use these in Postman or `curl` for your demo:

### Create a Category
```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Sports",
    "description": "Sports equipment and accessories"
  }'
```

### Create a Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Cricket Bat MRF",
    "description": "Professional grade cricket bat",
    "price": 3500.00,
    "stockQuantity": 30,
    "categoryId": 1
  }'
```

### Get All Products (with pagination)
```bash
curl "http://localhost:8080/api/products?page=0&size=5&sortBy=price"
```

### Search Products
```bash
curl "http://localhost:8080/api/products/search?name=samsung"
```

### Filter by Price Range
```bash
curl "http://localhost:8080/api/products/price-range?minPrice=1000&maxPrice=50000"
```

### Check Low Stock Items
```bash
curl "http://localhost:8080/api/products/low-stock?threshold=5"
```

### Update Stock
```bash
curl -X PATCH "http://localhost:8080/api/products/3/stock?quantity=100"
```

---

## 🎯 Key Design Decisions

### 1. Soft Delete
Products are never actually deleted from the database. Instead, `active = false` is set. This means:
- Data can be recovered if deleted by mistake
- Historical order data remains intact
- Audit trails are preserved

### 2. BigDecimal for Money
All prices use `BigDecimal` instead of `float` or `double`. Floating-point types have precision errors (e.g., `0.1 + 0.2 = 0.30000000000000004`). For financial data, `BigDecimal` is the only correct choice.

### 3. Global Exception Handling
All exceptions are caught by `GlobalExceptionHandler` using `@RestControllerAdvice`. This means:
- No try-catch blocks needed in controllers
- Consistent error response format across all endpoints
- Clean, readable controller code

### 4. DTOs (Data Transfer Objects)
Raw JPA entities are never returned directly from controllers. DTOs:
- Prevent accidental exposure of sensitive fields
- Allow independent evolution of API and database schemas
- Make the API contract explicit and stable

### 5. Layered Architecture
Strict separation of Controller → Service → Repository ensures:
- Each layer has one responsibility (Single Responsibility Principle)
- Easy to unit test each layer in isolation
- Easy to swap implementations (e.g., change MySQL to PostgreSQL)

### 6. Pagination
All "list all" endpoints support pagination (`page`, `size`, `sortBy`) to prevent returning thousands of records and crashing the client.

---

## 🔮 Future Enhancements

- [ ] JWT Authentication & Authorization
- [ ] Product image upload (AWS S3)
- [ ] Elasticsearch for advanced product search
- [ ] Redis caching for frequently accessed products
- [ ] Order management module
- [ ] Swagger/OpenAPI documentation (`/swagger-ui.html`)
- [ ] Docker + docker-compose setup
- [ ] CI/CD pipeline with GitHub Actions

---

## 👨‍💻 Author

Built with ❤️ for a team demo using Spring Boot best practices.
