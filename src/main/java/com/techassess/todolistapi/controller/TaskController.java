package com.techassess.todolistapi.controller;

import com.techassess.todolistapi.model.Task;
import com.techassess.todolistapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/users/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId){
        return taskService.getTasksByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Task> createNewTask(@RequestBody Task task){
        Task created = taskService.addNewTask(task);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        Task updated = taskService.updateTask(task);
        return task;
    }

    @DeleteMapping("/{taskId}")
    public boolean deleteTask(@PathVariable Long taskId){
        return taskService.deleteTask(taskId);
    }
}
