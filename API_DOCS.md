# API Documentation — TCC Gym Management

Base URL: `http://localhost:8080`

---

## Table of Contents

- [Gyms](#gyms)
- [Equipment Types](#equipment-types)
- [Equipment](#equipment)
- [Users](#users)
- [Maintenances](#maintenances)
- [Maintenance Requests](#maintenance-requests)
- [Maintenance Repair Services](#maintenance-repair-services)

---

## Gyms

### `GET /gyms`
Returns all gyms.

**Response `200 OK`**
```json
[
  {
    "id": "64a1b2c3d4e5f6a7b8c9d0e1",
    "name": "BioCorpo",
    "document": "12345678000199",
    "phoneNumber": "11987654321",
    "email": "contato@biocorpo.com",
    "address": "Rua das Flores, 123, São Paulo, SP"
  }
]
```

---

### `GET /gyms/{id}`
Returns a single gym by ID.

**Response `200 OK`**
```json
{
  "id": "64a1b2c3d4e5f6a7b8c9d0e1",
  "name": "BioCorpo",
  "document": "12345678000199",
  "phoneNumber": "11987654321",
  "email": "contato@biocorpo.com",
  "address": "Rua das Flores, 123, São Paulo, SP"
}
```

**Response `404 Not Found`** — gym ID does not exist.

---

### `POST /gyms`
Creates a new gym.

**Request Body**
```json
{
  "name": "BioCorpo",
  "document": "12345678000199",
  "phoneNumber": "11987654321",
  "email": "contato@biocorpo.com",
  "address": "Rua das Flores, 123, São Paulo, SP"
}
```

**Response `201 Created`** — `Location` header contains the URI of the created resource. No body.

---

### `PUT /gyms/{id}`
Updates an existing gym.

**Request Body** — same shape as POST, with all fields.
```json
{
  "id": "64a1b2c3d4e5f6a7b8c9d0e1",
  "name": "BioCorpo Premium",
  "document": "12345678000199",
  "phoneNumber": "11999990000",
  "email": "premium@biocorpo.com",
  "address": "Av. Paulista, 1000, São Paulo, SP"
}
```

**Response `204 No Content`**

---

### `DELETE /gyms/{id}`
Deletes a gym by ID.

**Response `204 No Content`**

---

## Equipment Types

### `GET /equipment-types`
Returns all equipment types.

**Response `200 OK`**
```json
[
  {
    "id": "64b2c3d4e5f6a7b8c9d0e1f2",
    "name": "Esteira",
    "description": "Equipamento de caminhada e corrida"
  },
  {
    "id": "64b2c3d4e5f6a7b8c9d0e1f3",
    "name": "Haltere",
    "description": "Equipamento de musculação livre"
  }
]
```

---

### `GET /equipment-types/{id}`
Returns a single equipment type by ID.

**Response `200 OK`**
```json
{
  "id": "64b2c3d4e5f6a7b8c9d0e1f2",
  "name": "Esteira",
  "description": "Equipamento de caminhada e corrida"
}
```

**Response `404 Not Found`** — type ID does not exist.

---

### `POST /equipment-types`
Creates a new equipment type.

**Request Body**
```json
{
  "name": "Esteira",
  "description": "Equipamento de caminhada e corrida"
}
```

**Response `201 Created`** — `Location` header with URI. No body.

---

### `PUT /equipment-types`
Updates an existing equipment type. The `id` field in the body is used to locate the record.

**Request Body**
```json
{
  "id": "64b2c3d4e5f6a7b8c9d0e1f2",
  "name": "Esteira Motorizada",
  "description": "Equipamento de caminhada e corrida com motor"
}
```

**Response `204 No Content`**

---

### `DELETE /equipment-types/{id}`
Deletes an equipment type by ID.

**Response `204 No Content`**

---

## Equipment

### `GET /equipments`
Returns all equipment.

**Response `200 OK`**
```json
[
  {
    "id": "64c3d4e5f6a7b8c9d0e1f2a3",
    "name": "Haltere 10kg",
    "description": "Par de halteres de 10kg",
    "propertyNumber": "HAL-001",
    "purchaseDate": "2023-01-15T03:00:00.000+00:00",
    "originalValue": 250.00,
    "currentValue": 200.00,
    "depreciationPercentage": 20.0,
    "durability": 90.0,
    "equipmentType": {
      "id": "64b2c3d4e5f6a7b8c9d0e1f3",
      "name": "Haltere",
      "description": "Equipamento de musculação livre"
    },
    "gymDTO": {
      "id": "64a1b2c3d4e5f6a7b8c9d0e1",
      "name": "BioCorpo",
      "document": "12345678000199",
      "phoneNumber": "11987654321"
    }
  }
]
```

---

### `GET /equipments/{id}`
Returns a single equipment item by ID.

**Response `200 OK`** — same shape as a single item from the list above.

**Response `404 Not Found`** — equipment ID does not exist.

---

### `POST /equipments`
Creates a new equipment item.

**Request Body**
```json
{
  "name": "Haltere 10kg",
  "description": "Par de halteres de 10kg",
  "propertyNumber": "HAL-001",
  "purchaseDate": "2023-01-15",
  "originalValue": 250.00,
  "currentValue": 200.00,
  "depreciationPercentage": 20.0,
  "durability": 90.0,
  "equipmentType": {
    "id": "64b2c3d4e5f6a7b8c9d0e1f3",
    "name": "Haltere",
    "description": "Equipamento de musculação livre"
  },
  "gymDTO": {
    "id": "64a1b2c3d4e5f6a7b8c9d0e1",
    "name": "BioCorpo",
    "document": "12345678000199",
    "phoneNumber": "11987654321"
  }
}
```

**Response `201 Created`** — `Location` header with URI. No body.

---

### `PUT /equipments/{id}`
Updates an existing equipment item.

**Request Body** — same shape as POST, all fields required.

**Response `204 No Content`**

---

### `DELETE /equipments/{id}`
Deletes an equipment item by ID.

**Response `204 No Content`**

---

## Users

### `GET /users`
Returns all users. Passwords are **not** included in this response (returns `UserDTO`).

**Response `200 OK`**
```json
[
  {
    "id": "64d4e5f6a7b8c9d0e1f2a3b4",
    "name": "Ronery Silva",
    "email": "ronery@biocorpo.com",
    "document": "11122233344"
  }
]
```

---

### `GET /users/{id}`
Returns a single user by ID, including all fields.

**Response `200 OK`**
```json
{
  "id": "64d4e5f6a7b8c9d0e1f2a3b4",
  "name": "Ronery Silva",
  "userName": "ronery",
  "password": "senha123",
  "document": "11122233344",
  "email": "ronery@biocorpo.com",
  "phoneNumber": "11911112222",
  "gymDTO": {
    "id": "64a1b2c3d4e5f6a7b8c9d0e1",
    "name": "BioCorpo",
    "document": "12345678000199",
    "phoneNumber": "11987654321"
  }
}
```

**Response `404 Not Found`** — user ID does not exist.

---

### `POST /users`
Creates a new user. `userName` must be unique.

**Request Body**
```json
{
  "name": "Ronery Silva",
  "userName": "ronery",
  "password": "senha123",
  "document": "11122233344",
  "email": "ronery@biocorpo.com",
  "phoneNumber": "11911112222",
  "gymDTO": {
    "id": "64a1b2c3d4e5f6a7b8c9d0e1",
    "name": "BioCorpo",
    "document": "12345678000199",
    "phoneNumber": "11987654321"
  }
}
```

**Response `201 Created`** — `Location` header with URI. No body.

> Returns `400 Bad Request` if `userName` is already taken.

---

### `PUT /users/{id}`
Updates an existing user. Only `name`, `document`, `email`, and `phoneNumber` are updated; `userName` and `password` are ignored.

**Request Body**
```json
{
  "id": "64d4e5f6a7b8c9d0e1f2a3b4",
  "name": "Ronery Silva Atualizado",
  "document": "11122233344",
  "email": "ronery.novo@biocorpo.com",
  "phoneNumber": "11933334444"
}
```

**Response `204 No Content`**

---

### `DELETE /users/{id}`
Deletes a user by ID.

**Response `204 No Content`**

---

### `POST /users/login/{userName}/{password}`
Authenticates a user by `userName` and `password` (case-insensitive password comparison).

**Path Parameters**
| Parameter  | Description                |
|------------|----------------------------|
| `userName` | The user's unique username |
| `password` | The user's plain-text password |

**Response `200 OK`** — returns the full `User` object (same shape as `GET /users/{id}`).

**Response `401 Unauthorized`** — username found but password does not match.

**Response `404 Not Found`** — username does not exist.

---

## Maintenances

Maintenance records represent external repair service companies.

### `GET /maintenances`
Returns all maintenance providers.

**Response `200 OK`**
```json
[
  {
    "id": "64e5f6a7b8c9d0e1f2a3b4c5",
    "name": "José Consertos",
    "document": "98765432100",
    "phoneNumber": "11944445555",
    "email": "jose@consertos.com",
    "address": "Rua dos Reparos, 55, São Paulo, SP",
    "contactEmployee": "José Oliveira",
    "gymDTO": {
      "id": "64a1b2c3d4e5f6a7b8c9d0e1",
      "name": "BioCorpo",
      "document": "12345678000199",
      "phoneNumber": "11987654321"
    }
  }
]
```

---

### `GET /maintenances/{id}`
Returns a single maintenance provider by ID.

**Response `200 OK`** — same shape as a single item from the list above.

**Response `404 Not Found`** — maintenance ID does not exist.

---

### `POST /maintenances`
Creates a new maintenance provider.

**Request Body**
```json
{
  "name": "José Consertos",
  "document": "98765432100",
  "phoneNumber": "11944445555",
  "email": "jose@consertos.com",
  "address": "Rua dos Reparos, 55, São Paulo, SP",
  "contactEmployee": "José Oliveira",
  "gymDTO": {
    "id": "64a1b2c3d4e5f6a7b8c9d0e1",
    "name": "BioCorpo",
    "document": "12345678000199",
    "phoneNumber": "11987654321"
  }
}
```

**Response `201 Created`** — `Location` header with URI. No body.

---

### `PUT /maintenances/{id}`
Updates an existing maintenance provider.

**Request Body** — same shape as POST, all fields required.

**Response `204 No Content`**

---

### `DELETE /maintenances/{id}`
Deletes a maintenance provider by ID.

**Response `204 No Content`**

---

## Maintenance Requests

### `GET /requests`
Returns all maintenance requests.

**Response `200 OK`**
```json
[
  {
    "id": "64f6a7b8c9d0e1f2a3b4c5d6",
    "requestNumber": 1,
    "description": "Esteira com defeito no motor",
    "observation": "Equipamento parado, urgente",
    "createdAt": "28/03/2026",
    "updatedAt": null,
    "closedAt": null,
    "maintenanceDTO": {
      "id": "64e5f6a7b8c9d0e1f2a3b4c5",
      "name": "José Consertos",
      "phone": "11944445555",
      "document": "98765432100"
    },
    "userDTO": {
      "id": "64d4e5f6a7b8c9d0e1f2a3b4",
      "name": "Ronery Silva",
      "email": "ronery@biocorpo.com",
      "document": "11122233344"
    },
    "equipments": [
      {
        "id": "64c3d4e5f6a7b8c9d0e1f2a3",
        "name": "Esteira Philco",
        "description": "Esteira para corrida",
        "propertyNumber": "EST-001",
        "purchaseDate": "2022-06-01T03:00:00.000+00:00",
        "originalValue": 3000.00,
        "currentValue": 2100.00,
        "depreciationPercentage": 30.0,
        "durability": 75.0,
        "equipmentType": {
          "id": "64b2c3d4e5f6a7b8c9d0e1f2",
          "name": "Esteira",
          "description": "Equipamento de caminhada e corrida"
        },
        "gymDTO": {
          "id": "64a1b2c3d4e5f6a7b8c9d0e1",
          "name": "BioCorpo",
          "document": "12345678000199",
          "phoneNumber": "11987654321"
        }
      }
    ],
    "maintenances": [
      {
        "id": "64e5f6a7b8c9d0e1f2a3b4c5",
        "name": "José Consertos",
        "phone": "11944445555",
        "document": "98765432100"
      }
    ],
    "services": [],
    "conditions": ["DEFEITO_MOTOR", "EQUIPAMENTO_PARADO"]
  }
]
```

---

### `GET /requests/{id}`
Returns a single maintenance request by ID.

**Response `200 OK`** — same shape as a single item from the list above.

**Response `404 Not Found`** — request ID does not exist.

---

### `POST /requests`
Creates a new maintenance request.

**Request Body**
```json
{
  "requestNumber": 1,
  "description": "Esteira com defeito no motor",
  "observation": "Equipamento parado, urgente",
  "createdAt": "28/03/2026",
  "maintenanceDTO": {
    "id": "64e5f6a7b8c9d0e1f2a3b4c5",
    "name": "José Consertos",
    "phone": "11944445555",
    "document": "98765432100"
  },
  "userDTO": {
    "id": "64d4e5f6a7b8c9d0e1f2a3b4",
    "name": "Ronery Silva",
    "email": "ronery@biocorpo.com",
    "document": "11122233344"
  },
  "equipments": [
    {
      "id": "64c3d4e5f6a7b8c9d0e1f2a3",
      "name": "Esteira Philco",
      "description": "Esteira para corrida",
      "propertyNumber": "EST-001",
      "purchaseDate": "2022-06-01",
      "originalValue": 3000.00,
      "currentValue": 2100.00,
      "depreciationPercentage": 30.0,
      "durability": 75.0,
      "equipmentType": {
        "id": "64b2c3d4e5f6a7b8c9d0e1f2",
        "name": "Esteira",
        "description": "Equipamento de caminhada e corrida"
      },
      "gymDTO": {
        "id": "64a1b2c3d4e5f6a7b8c9d0e1",
        "name": "BioCorpo",
        "document": "12345678000199",
        "phoneNumber": "11987654321"
      }
    }
  ],
  "maintenances": [
    {
      "id": "64e5f6a7b8c9d0e1f2a3b4c5",
      "name": "José Consertos",
      "phone": "11944445555",
      "document": "98765432100"
    }
  ],
  "services": [],
  "conditions": ["DEFEITO_MOTOR", "EQUIPAMENTO_PARADO"]
}
```

**Response `201 Created`** — `Location` header with URI. No body.

---

### `PUT /requests/{id}`
Updates an existing maintenance request.

**Request Body** — same shape as POST, all fields required.

**Response `204 No Content`**

---

### `DELETE /requests/{id}`
Deletes a maintenance request by ID.

**Response `204 No Content`**

---

## Maintenance Repair Services

Individual repair line items linked to a maintenance request.

### `GET /maintenance-repair-services`
Returns all repair services.

**Response `200 OK`**
```json
[
  {
    "id": "64a7b8c9d0e1f2a3b4c5d6e7",
    "description": "Substituição do motor da esteira",
    "subTotal": 800.00,
    "finalPrice": 950.00,
    "maintenance": {
      "id": "64e5f6a7b8c9d0e1f2a3b4c5",
      "name": "José Consertos",
      "document": "98765432100",
      "phoneNumber": "11944445555",
      "email": "jose@consertos.com",
      "address": "Rua dos Reparos, 55, São Paulo, SP",
      "contactEmployee": "José Oliveira",
      "gymDTO": {
        "id": "64a1b2c3d4e5f6a7b8c9d0e1",
        "name": "BioCorpo",
        "document": "12345678000199",
        "phoneNumber": "11987654321"
      }
    },
    "maintenanceRequestDTO": {
      "id": "64f6a7b8c9d0e1f2a3b4c5d6",
      "requestNumber": 1,
      "createdAt": "28/03/2026"
    },
    "equipmentList": [
      {
        "id": "64c3d4e5f6a7b8c9d0e1f2a3",
        "name": "Esteira Philco",
        "description": "Esteira para corrida",
        "propertyNumber": "EST-001",
        "purchaseDate": "2022-06-01T03:00:00.000+00:00",
        "originalValue": 3000.00,
        "currentValue": 2100.00,
        "depreciationPercentage": 30.0,
        "durability": 75.0,
        "equipmentType": {
          "id": "64b2c3d4e5f6a7b8c9d0e1f2",
          "name": "Esteira",
          "description": "Equipamento de caminhada e corrida"
        },
        "gymDTO": {
          "id": "64a1b2c3d4e5f6a7b8c9d0e1",
          "name": "BioCorpo",
          "document": "12345678000199",
          "phoneNumber": "11987654321"
        }
      }
    ]
  }
]
```

---

### `GET /maintenance-repair-services/{id}`
Returns a single repair service by ID.

**Response `200 OK`** — same shape as a single item from the list above.

**Response `404 Not Found`** — service ID does not exist.

---

### `POST /maintenance-repair-services`
Creates a new repair service.

**Request Body**
```json
{
  "description": "Substituição do motor da esteira",
  "subTotal": 800.00,
  "finalPrice": 950.00,
  "maintenance": {
    "id": "64e5f6a7b8c9d0e1f2a3b4c5",
    "name": "José Consertos",
    "document": "98765432100",
    "phoneNumber": "11944445555",
    "email": "jose@consertos.com",
    "address": "Rua dos Reparos, 55, São Paulo, SP",
    "contactEmployee": "José Oliveira",
    "gymDTO": {
      "id": "64a1b2c3d4e5f6a7b8c9d0e1",
      "name": "BioCorpo",
      "document": "12345678000199",
      "phoneNumber": "11987654321"
    }
  },
  "maintenanceRequestDTO": {
    "id": "64f6a7b8c9d0e1f2a3b4c5d6",
    "requestNumber": 1,
    "createdAt": "28/03/2026"
  },
  "equipmentList": [
    {
      "id": "64c3d4e5f6a7b8c9d0e1f2a3",
      "name": "Esteira Philco",
      "description": "Esteira para corrida",
      "propertyNumber": "EST-001",
      "purchaseDate": "2022-06-01",
      "originalValue": 3000.00,
      "currentValue": 2100.00,
      "depreciationPercentage": 30.0,
      "durability": 75.0,
      "equipmentType": {
        "id": "64b2c3d4e5f6a7b8c9d0e1f2",
        "name": "Esteira",
        "description": "Equipamento de caminhada e corrida"
      },
      "gymDTO": {
        "id": "64a1b2c3d4e5f6a7b8c9d0e1",
        "name": "BioCorpo",
        "document": "12345678000199",
        "phoneNumber": "11987654321"
      }
    }
  ]
}
```

**Response `201 Created`** — `Location` header with URI. No body.

---

### `PUT /maintenance-repair-services/{id}`
Updates an existing repair service.

**Request Body** — same shape as POST, all fields required.

**Response `204 No Content`**

---

### `DELETE /maintenance-repair-services/{id}`
Deletes a repair service by ID.

**Response `204 No Content`**

---

## HTTP Status Code Summary

| Code | Meaning |
|------|---------|
| `200 OK` | Successful GET or login |
| `201 Created` | Resource created; `Location` header points to the new resource |
| `204 No Content` | Successful PUT or DELETE |
| `400 Bad Request` | Duplicate `userName` on user creation |
| `401 Unauthorized` | Login — correct username but wrong password |
| `404 Not Found` | Resource not found by ID, or login with unknown username |

## Notes

- All `id` fields are MongoDB ObjectId strings generated automatically; omit them on POST requests.
- Nested objects (e.g., `gymDTO`, `equipmentType`) must be sent with their `id` fields so the service can resolve the reference.
- `PUT /equipment-types` does **not** take the ID as a path variable — the `id` field inside the body is used instead.
- `createdAt` on `MaintenanceRequest` is a `String` in `dd/MM/yyyy` format.
- `purchaseDate` on `Equipment` is a `Date`; ISO 8601 strings (e.g., `"2023-01-15"`) are accepted.
- `userName` on `User` is unique and indexed; attempting to register a duplicate will be rejected.
