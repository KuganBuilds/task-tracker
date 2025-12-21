package com.kuganBuilds.tasktracker.ui;

import com.kuganBuilds.tasktracker.model.Task;
import com.kuganBuilds.tasktracker.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final TaskService taskService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
    }


    public void start(){
        boolean running = true;

        while (running){
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addTaskUI();
                case 2 -> viewTaskUI();
                case 3 -> completeTaskUI();
                case 4 -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }


        }
        System.out.println("Exiting Task Tracker. Stay productive.");
    }


    private void showMenu(){
        System.out.println("===  TASK TRACKER MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Exit");
        System.out.print("Choose the option : ");
    }


    //Add Task UI
    private void addTaskUI(){
        System.out.print("Title : ");
        String title = scanner.nextLine();


        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Due Date (YYYY-MM-DD) ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        taskService.addTask(title,description,date);
    }


    //View All task UI
    private void viewTaskUI(){
        List<Task> tasks = taskService.getAllTasks();

        if (tasks.isEmpty()){
            System.out.println("No task available");
            return;
        }

        System.out.println("\n--- TASK LIST ---");
        for (Task task : tasks) {
            System.out.println(
                    task.getId() + " | " +
                            task.getTitle() + " | " +
                            (task.isCompleted() ? "DONE" : "PENDING") +
                            " | Due: " + task.getDueDate()
            );

        }
    }


    //Task Completed UI
    private void completeTaskUI() {
        System.out.print("Enter Task ID to complete: ");
        long taskId = scanner.nextLong();

        boolean completed = taskService.completeTask(taskId);

        if (completed) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

}
