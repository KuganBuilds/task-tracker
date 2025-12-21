package com.kuganBuilds.tasktracker;


import com.kuganBuilds.tasktracker.service.TaskService;

import java.time.LocalDate;

public class TaskTrackerApp
{
    public static void main( String[] args )
    {
        TaskService taskService = new TaskService();

        taskService.addTask(
                "Learn Java service Layer",
                "Understand bussiness Logic separation",
                LocalDate.now().plusDays(2)
        );

        taskService.addTask(
                "Build Task Tracker",
                "First resume-ready backend project",
                LocalDate.now().plusDays(5)
        );

        taskService.getAllTasks().forEach(task -> System.out.println(task.getId()
        + " | " + task.getTitle()));

        taskService.completeTask(1);
    }
}
