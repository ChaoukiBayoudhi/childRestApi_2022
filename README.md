# Child Rest API 2022

A REST API built with Spring Boot around 6 JPA entities, using PostgreSQL.

## Tech stack

- Java 19, built with Maven
- Spring Boot 2.7.4
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`monitoring_db` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Child` | id, firstName, lastName, birthDate, schoolGrade, photo, supervisorParent, childTasks, childMessages |
| `Task` | id, name, duration, state, type, startDateTime, endDateTime, report, children, taskPlace |
| `Parent` | id, name, familyName, birthDate, email, photo, children |
| `Report` | id, text, date, facedProblems, benefits, task |
| `Place` | id, name, address, notes, longitude, latitude, tasks |
| `Message` | id, content, dateTime, child |

## REST endpoints

Found in the controllers (`ChildController`):

| Method | Path |
|---|---|
| GET | `/all` |
| GET | `/child/{id}` |
| POST | `/add` |
| DELETE | `/remove/{id}` |

## Project structure

- `tn.esb.bis.childRestApi`: ChildRestApiApplication
- `tn.esb.bis.childRestApi.Domains`: Child, Message, Parent, Place, Report, Task
- `tn.esb.bis.childRestApi.Enumerations`: TaskState, TaskType
- `tn.esb.bis.childRestApi.Repositories`: ChildRepository, MessageRepository, ParentRepository, PlaceRepository, ReportRepository, TaskRepository
- `tn.esb.bis.childRestApi.Services`: ChildService, MessageService, ParentService, PlaceService, ReportService, TaskService
- `tn.esb.bis.childRestApi.Web`: ChildController, MessageController, ParentController, PlaceController, ReportController, TaskController
- Tests: 1 test class

## How to run

Requirements: a JDK 19+ and Maven (or the included Maven wrapper).
Create the `monitoring_db` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:8080`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
