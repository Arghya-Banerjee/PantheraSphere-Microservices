# 🐲 PantheraSphere Backend

A scalable microservices-based backend for **Tiger Sighting, Conservation, and Safari Management**.
Built with **Java Spring Boot** and **Microsoft SQL Server**.

---

# 📂 Microservices Developed So Far

| Service | Description |
|:--------|:------------|
| **User Service** | Handles user registration, authentication (Login/Signup), and role management (Admin/User). |
| **Forest Service** | Manages forests where tigers are found. |
| **Tiger Service** | Handles tiger records, their resident forests, and last sighting details. |
| **Safari Service** | Manages safaris and observation checklists during tiger sighting trips. |

---

# 🔗 API Endpoints

## 1. User Service

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| `POST` | `/api/users/register` | Register a new user |
| `POST` | `/api/users/login` | Login with email & password |
| `GET` | `/api/users/{id}` | Get user details by ID |

---

## 2. Forest Service

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| `POST` | `/api/forest` | Create a forest |
| `GET` | `/api/forest/{id}` | Get forest by ID |
| `GET` | `/api/forest` | Get all forests |
| `DELETE` | `/api/forest/{id}` | Delete a forest |
| `POST` | `/api/forest-type` | Create forest type (eg. Tropical, Grassland) |
| `GET` | `/api/forest-type` | Get all forest types |

---

## 3. Tiger Service

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| `POST` | `/api/tiger` | Add a tiger record |
| `GET` | `/api/tiger/{id}` | Get tiger by ID |
| `GET` | `/api/tiger` | Get all tigers |
| `DELETE` | `/api/tiger/{id}` | Delete a tiger record |

---

## 4. Safari Service (ChecklistHeader)

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| `POST` | `/api/checklist-header` | Create a safari trip (ChecklistHeader) |
| `GET` | `/api/checklist-header/{id}` | Get safari trip by ID |
| `GET` | `/api/checklist-header` | Get all safari trips |
| `DELETE` | `/api/checklist-header/{id}` | Delete a safari trip |

---

## 5. Safari Service (ChecklistItem - Observations)

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| `POST` | `/api/checklist-item` | Create a tiger observation during safari |
| `GET` | `/api/checklist-item/{id}` | Get observation by ID |
| `GET` | `/api/checklist-item` | Get all observations |
| `DELETE` | `/api/checklist-item/{id}` | Delete an observation |

---

# 📁 Folder Structure (Per Service)

```
service-name/
|-- controller/
|-- entity/
|-- dto/
|-- repository/
|-- service/
|   |-- impl/
|-- application.properties
|-- ServiceApplication.java
```

- Clean separation between Controller, Service, Repository layers.
- DTOs used for clean API request/response.
- UUID (uniqueidentifier) primary keys everywhere.

---

# 📈 Database Design

- Microsoft SQL Server used.
- Separate databases per service (no cross-database joins).
- UUIDs for Primary Keys.
- Proper foreign key relationships inside each service database.
- Dropped and recreated tables cleanly to match Hibernate schema validation.

---

# 🌟 Future Work

- **User Service**
  - JWT Authentication (token based login)
  - Password hashing (BCrypt)
  - Role-based access control (Admin/User)

- **Safari Service**
  - Validation (add @Valid for DTOs)
  - Exception Handling (Custom Error responses)
  - Pagination for large safari and observation lists

- **Tiger Service**
  - Upload tiger images
  - Track tiger movements between forests

- **Overall**
  - Swagger/OpenAPI documentation
  - Dockerize each service
  - Setup centralized config server
  - API Gateway + Service Discovery (Eureka)

---

# 🚀 Tech Stack

- **Backend**: Java 17, Spring Boot 3.x
- **Database**: Microsoft SQL Server
- **Build Tool**: Maven
- **Testing Tool**: Postman
- **Authentication**: (Planned) JWT
- **Architecture**: Microservices

---

# 📅 Current Status: 

> **Initial backend development complete. Moving into testing and enhancements phase.**

---

# 🔍 Credits

Developed by: [Arghya Banerjee]

---

# 📚 License

> PantheraSphere is developed as a non-commercial wildlife conservation tracking platform.
