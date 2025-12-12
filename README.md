# ToDoList API 

A simple RESTful API for managing tasks. This backend service is built using **Spring Boot**, with data persistence managed by **MyBatis** and **PostgreSQL**. 

## PREPARATION 

Please refer to application.yml to prepare the database before running the app.
## Base URL

All endpoints are prefixed with the following base URL:

`http://localhost:8080/api/tasks`

---

## API Endpoints

### 1. Get Tasks by User (with optional pagination)

Retrieves a list of tasks associated with a specific user, supporting optional pagination for efficient data loading.

* **Endpoint:**
  `GET /users/{userId}?page={page}&size={size}`

* **Response:**
  A list of `TaskResponseDTO` objects.

* **Example Request (Postman):**
    ```
    GET http://localhost:8080/api/tasks/users/1?page=1&size=5
    ```

---

### 2. Create a New Task

Adds a new task to the system.

* **Endpoint:**
  `POST /`

* **Request Body (`CreateTaskDTO`):**
    ```json
    {
      "userId": 1,
      "title": "Test Task",
      "description": "Task description",
      "status": "PENDING",
      "priority": 2,
      "deadline": "2025-12-12T10:00:00"
    }
    ```

* **Response:**
  The created task (`TaskResponseDTO`) including the generated `id`, `createdAt`, and `updatedAt` timestamps.

---

### 3. Update a Task

Modifies the details of an existing task specified by its ID.

* **Endpoint:**
  `PUT /{taskId}`

* **Request Body (`UpdateTaskDTO`):**
    ```json
    {
      "id": 1,
      "title": "Updated Task",
      "description": "Updated description",
      "status": "COMPLETED",
      "priority": 1,
      "deadline": "2025-12-13T10:00:00"
    }
    ```

* **Response:**
  The updated task (`TaskResponseDTO`).

* **Example Request (Postman):**
    ```
    PUT http://localhost:8080/api/tasks/1
    ```

---

### 4. Delete a Task

Removes a task from the system using its ID.

* **Endpoint:**
  `DELETE /{taskId}`

* **Example Request (Postman):**
    ```
    DELETE http://localhost:8080/api/tasks/1
    ```

---

#### Status Values

The possible values for the `status` field:

* `PENDING`
* `OVERDUE`
* `COMPLETED`

---