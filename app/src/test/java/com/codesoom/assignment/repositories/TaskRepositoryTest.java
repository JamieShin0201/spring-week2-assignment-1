package com.codesoom.assignment.repositories;

import com.codesoom.assignment.IdGenerator;
import com.codesoom.assignment.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepositoryTest {

    TaskRepository taskRepository;
    IdGenerator idGenerator;

    @BeforeEach
    void setUp() {
        idGenerator = new IdGenerator();
        taskRepository = new TaskRepository(idGenerator);
    }

    @Test
    void getEmptyTasks() {
        List<Task> tasks = taskRepository.findAll();

        assertEquals(0, tasks.size());
    }

    @Test
    void getTasks() {
        Task task1 = new Task(idGenerator.generateId(), "task1");
        Task task2 = new Task(idGenerator.generateId(), "task2");

        taskRepository.save(task1);
        taskRepository.save(task2);
        List<Task> tasks = taskRepository.findAll();

        assertEquals(2, tasks.size());
    }

    @Test
    void addTask() {
        Task task1 = new Task(idGenerator.generateId(), "task1");

        taskRepository.save(task1);
        List<Task> tasks = taskRepository.findAll();

        assertEquals(1, tasks.size());
    }

}