Task Tracker – Java CLI Application

Project URL : https://roadmap.sh/projects/task-tracker

A console-based Task Tracker application built using Core Java.
This project allows users to manage tasks using a simple
menu-driven command-line interface.

It focuses on clean layering, date handling, and safe input
processing in a real-world CLI application.

------------------------------------------------------------

FEATURES
- Add a task with title, description, and due date
- View all tasks in a formatted table
- Mark a task as completed by ID
- Auto-increment task IDs
- Task status management (PENDING / DONE)
- Input validation for date and user input
- Clean separation of UI, Service, and Repository layers

------------------------------------------------------------

TECH STACK
- Java (Core Java)
- Java Collections (ArrayList)
- java.time.LocalDate
- CLI using Scanner
- In-memory storage

------------------------------------------------------------

PROJECT STRUCTURE
```
src/
 ├── console/
 │   └── ConsoleUI.java
 ├── model/
 │   └── Task.java
 ├── repository/
 │   └── TaskRepository.java
 ├── service/
 │   └── TaskService.java
 └── Main.java
```

------------------------------------------------------------

HOW TO RUN
1. Clone the repository
   git clone https://github.com/KuganBuilds/task-tracker.git

2. Compile the project
   javac Main.java

3. Run the application
   java Main

------------------------------------------------------------

APPLICATION MENU
```
=== TASK TRACKER MENU ===
1. Add Task
2. View Tasks
3. Mark Task as Completed
4. Exit
```
------------------------------------------------------------

SAMPLE USAGE
```
Add Task:
Title: Java learning
Description: want to learn spring
Due date (YYYY-MM-DD): 2025-12-28
Task added successfully.
```

View Tasks:
```
ID | TITLE | STATUS | DUE DATE
----------------------------------
1 | Java Learning | DONE | 2025-12-21
2 | SpringBoot Learning | PENDING | 2025-12-21
3 | Java learning | PENDING | 2025-12-28
```

Mark Task as Completed:
```
Enter Task ID to complete: 2
Task marked as completed.
```

Updated Task List:

```
ID | TITLE | STATUS | DUE DATE
----------------------------------
1 | Java Learning | DONE | 2025-12-21
2 | SpringBoot Learning | DONE | 2025-12-21
3 | Java learning | PENDING | 2025-12-28
```
------------------------------------------------------------

VALIDATION RULES
- Task title cannot be empty
- Due date must follow YYYY-MM-DD format
- Invalid task IDs are handled safely
- Prevents application crashes on invalid input

------------------------------------------------------------

LEARNING OUTCOMES
- Building menu-driven CLI applications
- Managing state using collections
- Working with LocalDate
- Applying clean separation of concerns
- Implementing update operations using IDs

------------------------------------------------------------

FUTURE ENHANCEMENTS (OPTIONAL)
- Persist tasks to a file (JSON / CSV)
- Add task priorities
- Add task categories
- Filter tasks by status
- Unit testing
- Web version using Spring Boot

------------------------------------------------------------

PROJECT STATUS
Completed (v1.0)

This project is complete and stable.
Next step: rebuilding this application using Spring Boot.

------------------------------------------------------------

AUTHOR
Kugan
Aspiring Java Full Stack Developer

