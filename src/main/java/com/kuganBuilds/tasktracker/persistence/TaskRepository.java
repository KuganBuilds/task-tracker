package com.kuganBuilds.tasktracker.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kuganBuilds.tasktracker.model.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";
    private final ObjectMapper objectMapper;

    public TaskRepository() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Task> loadTasks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load tasks", e);
        }
    }

    public void saveTasks(List<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_NAME), tasks);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save tasks", e);
        }
    }
}
