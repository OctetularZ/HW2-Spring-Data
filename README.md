# 🎓 My Second Spring Boot App – School, Pupils & Grades Management System

**Technologies:** `Java`, `Spring Boot`, `Spring MVC`, `Spring Data JPA`, `MySQL`, `JSP`

---

This project was developed as part of a university coursework assignment. The goal was to create a system for managing **schools**, their **pupils**, and corresponding **grades** using Spring Boot and JPA. The application demonstrates full-stack Java development using a **MySQL database**, **JPA entity relationships**, **form handling**, and **MVC architecture**.

---

## ⚙️ Task Breakdown

### 🔧 Task 1: Project Configuration (12 Marks)

- Added all necessary dependencies for:
  - Connecting to a **MySQL** database
  - Supporting **JSP** as view technology
- Configured:
  - MySQL connection settings (URL, username, password)
  - Enabled SQL logging to console for debugging

---

### 🧱 Task 2: Domain Classes (15 Marks)

#### `School`
- `id`, `location`, `List<Pupil> pupils`, `Pupil representative`

#### `Pupil`
- `name`, `List<School> schools`, `List<Grade> grades`, `Grade best`

#### `Grade`
- `identifier`, `mark`

Each class includes:
- ✅ Getters & setters
- ✅ Custom `toString()` methods formatted as:
  - `id=X`, `name='X'`, `grades=[...]`, `best={...}`

---

### 🧩 Task 3: JPA Annotations (25 Marks)

- Annotated `School`, `Pupil`, and `Grade` as **JPA entities**
- Primary key generation and mapping:
  - `@Id`, `@GeneratedValue` on `School.id` and `Grade.identifier`
  - `Pupil.name` used as primary key

#### Entity Relationships:

- 🔁 `@ManyToMany` between `School` and `Pupil` (bidirectional with `mappedBy`)
- 📚 `@OneToMany` `Pupil → Grade` with `@JoinColumn`
- ⭐ `@OneToOne` `Pupil → Grade` for `best`
- 👥 `@ManyToOne` for `representative` shared among pupils
- 🧠 Cascade:
  - Saving a `School` saves its pupils
  - Deleting a `Pupil` deletes all their grades
  - Grades are eagerly fetched

✅ **Repositories** created in `co2123.hw2.repo`:
- `SchoolRepository`
- `PupilRepository`
- `GradeRepository`

---

### 🔍 Task 4: Custom Repository Methods (20 Marks)

Added custom `findBy...` query methods:

| Repository         | Method                                     |
|--------------------|--------------------------------------------|
| `SchoolRepository` | `findByLocation(String location)`          |
|                    | `findByRepresentative_Name(String name)`   |
| `PupilRepository`  | `findByName(String name)`                  |
| `GradeRepository`  | `findByMark(int mark)`                     |

> ⚠️ All methods follow the correct Spring Data naming conventions.

---

### 🖼️ Task 5: MVC: List & Delete Functionality (28 Marks)

#### ✅ Application Boot Data

- Implemented `CommandLineRunner` in `HW2Application`  
- Used repositories to create and store:
  - 1 `School`
  - 1 `Pupil`
  - 1 `Grade`
- Ensured no null fields and full relationships

#### ✅ ListController

- Routes:
  - `/listSchool` → List all schools
  - `/listPupil` → List all pupils
  - `/listGrade` → List all grades
- View: `list.jsp`
- Model attribute: `data`
- Output: Loop over entities with `toString()` representations

#### ✅ DeleteController

- Routes:
  - `/deleteSchool?id=5`
  - `/deletePupil?name=Example`
  - `/deleteGrade?identifier=2`
- Deletes entities by primary key
- Handles:
  - Pupil deletion and removal from all schools
  - Cascade delete for grades

---

## 🧠 What I Learned

- 🔧 Integrating Spring Boot with a MySQL relational database
- 🧩 Mapping complex **JPA relationships** (`@OneToMany`, `@ManyToMany`, etc.)
- 🎛️ Using **Spring Data JPA repositories** with custom queries
- 📄 Rendering views using JSP with model attributes
- 🗑️ Handling entity deletion and relationship cleanup
- 🧪 Populating databases with test data using `CommandLineRunner`

---

## 📁 Project Structure

```bash
src/
├── main/
│   ├── java/
│   │   └── co2123/hw2/
│   │       ├── controller/
│   │       │   ├── ListController.java
│   │       │   └── DeleteController.java
│   │       ├── model/
│   │       │   ├── School.java
│   │       │   ├── Pupil.java
│   │       │   └── Grade.java
│   │       ├── repo/
│   │       │   ├── SchoolRepository.java
│   │       │   ├── PupilRepository.java
│   │       │   └── GradeRepository.java
│   │       └── HW2Application.java
│   └── webapp/
│       └── WEB-INF/views/
│           └── list.jsp
