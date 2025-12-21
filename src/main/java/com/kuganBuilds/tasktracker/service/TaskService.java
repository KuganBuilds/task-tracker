package com.kuganBuilds.tasktracker.service;

import com.kuganBuilds.tasktracker.model.Task;
import com.kuganBuilds.tasktracker.persistence.TaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskService {


    private final TaskRepository repository = new TaskRepository();
    private List<Task> tasks;
    private long idCounter = 1;

    //Add Task
    public Task addTask(String title, String description, LocalDate dueDate) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past");
        }

        Task task = new Task(idCounter++, title, description, dueDate);
        tasks.add(task);
        repository.saveTasks(tasks);
        return task;
    }


    public TaskService() {
        this.tasks = repository.loadTasks();
        this.idCounter = tasks.stream()
                .mapToLong(Task::getId)
                .max()
                .orElse(0) + 1;
    }

    //getAllTasks
    public List<Task> getAllTasks(){
        return tasks;
    }

    //Mark task as Completed
    public boolean completeTask(long taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                if (task.isCompleted()) {
                    throw new IllegalStateException("Task already completed");
                }
                task.markCompleted();
                repository.saveTasks(tasks);
                return true;
            }
        }
        return false;
    }



}
