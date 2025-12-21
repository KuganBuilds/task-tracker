package com.kuganBuilds.tasktracker.service;

import com.kuganBuilds.tasktracker.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskService {


    private final List<Task> tasks = new ArrayList<>();
    private long idCounter = 1;

    //Add Task
    public Task addTask(String title, String description, LocalDate localDate){
        Task task = new Task(idCounter++,title,description,localDate);
        tasks.add(task);
        return task;
    }

    //getAllTasks
    public List<Task> getAllTasks(){
        return tasks;
    }

    //Mark task as Completed
    public boolean completeTask(long taskId){
        for (Task task : tasks){
            if (task.getId() == taskId){
                task.isCompleted();
                return true;
            }
        }
        return false;
    }
}
