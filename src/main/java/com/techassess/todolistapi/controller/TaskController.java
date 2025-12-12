package com.techassess.todolistapi.controller;

import com.techassess.todolistapi.dto.CreateTaskDTO;
import com.techassess.todolistapi.dto.TaskResponseDTO;
import com.techassess.todolistapi.dto.UpdateTaskDTO;
import com.techassess.todolistapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public List<TaskResponseDTO> getTasksByUserId(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return taskService.getTasksByUserId(userId, page, size);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createNewTask(@Valid @RequestBody CreateTaskDTO dto){
        TaskResponseDTO created = taskService.addNewTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @PathVariable Long taskId,
            @Valid @RequestBody UpdateTaskDTO dto){
        dto.setId(taskId);
        TaskResponseDTO updated = taskService.updateTask(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
