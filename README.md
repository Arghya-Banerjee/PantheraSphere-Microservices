
# PantheraSphere - Forest Service & Tiger Service

This repository contains the `forest-service` and `tiger-service` microservices for the PantheraSphere project, a scalable platform for tracking and conserving tiger sightings and forest data.

---

## 🌲 Forest Service

Handles forests and forest types.

### Base URL:
```
/api/v1/forest
```

### Endpoints:

| Method | Endpoint                  | Description                        |
|--------|----------------------------|------------------------------------|
| GET    | `/`                        | Get all forests                    |
| GET    | `/{forestId}`              | Get a forest by ID                 |
| GET    | `/by-type/{typeId}`        | Get forests by forest type         |
| GET    | `/by-state?state=XYZ`      | Get forests by state               |
| GET    | `/search?name=XYZ`         | Search forests by partial name     |
| GET    | `/sorted?by=field&order=asc/desc` | Get sorted forests           |
| GET    | `/paginated?page=0&size=10` | Get paginated forests             |
| POST   | `/`                        | Create a new forest                |
| PUT    | `/{forestId}`              | Update a forest                    |
| DELETE | `/{forestId}`              | Delete a forest                    |

---

## 🐅 Tiger Service

Handles tiger records, sightings, and associated forest links.

### Base URL:
```
/api/v1/tigers
```

### Endpoints:

| Method | Endpoint                          | Description                        |
|--------|------------------------------------|------------------------------------|
| GET    | `/`                                | Get all tigers                     |
| GET    | `/{tigerId}`                       | Get tiger by ID                    |
| GET    | `/by-forest/{forestId}`            | Get tigers in a forest             |
| GET    | `/by-gender?gender=M/F`            | Get tigers by gender               |
| GET    | `/search?name=XYZ`                 | Search tigers by partial name      |
| GET    | `/age-range?min=2&max=6`           | Get tigers by age range            |
| GET    | `/last-sighted/recent`             | Get recently sighted tigers        |
| POST   | `/`                                | Create a new tiger                 |
| PUT    | `/{tigerId}`                       | Update a tiger                     |
| PATCH  | `/{tigerId}/last-sighted`           | Update last sighted timestamp only |
| DELETE | `/{tigerId}`                       | Delete a tiger                     |

---

## 🛠️ Current Standards Followed

- **Primary Key**: UUID (uniqueidentifier in SQL Server)
- **Architecture**: Microservices (No cross-entity JPA relations)
- **Tech Stack**: Spring Boot, JPA, Hibernate 6+, MS SQL Server
- **DTO usage** for Create/Update clean request handling
- **Microservice-safe** foreign key handling (UUID IDs only)

---

## 🚀 Future Work

### Forest Service
- Add forest analytics APIs (area-based stats, state-wise distribution)
- Audit forest modifications (createdAt, modifiedAt fields)

### Tiger Service
- Add image uploads for each tiger
- Implement soft delete (add `isDeleted` flag)
- Integrate with Observation service (future)
- Add tiger movement tracking (sightings history)

### Other Services To Build
- `user-service` (for authentication, role management)
- `safari-service` (to log safari trips)
- `observation-service` (to record tiger sightings)
- `report-service` (for analytics and conservation reports)

---

## 🐯 PantheraSphere — Tracking Tomorrow's Tigers, Today.
