package com.kuganBuilds.tasktracker;


import com.kuganBuilds.tasktracker.service.TaskService;
import com.kuganBuilds.tasktracker.ui.ConsoleUI;

import java.time.LocalDate;

public class TaskTrackerApp
{
    public static void main( String[] args )
    {
        TaskService taskService = new TaskService();
        ConsoleUI consoleUI = new ConsoleUI(taskService);

        consoleUI.start();
    }
}
