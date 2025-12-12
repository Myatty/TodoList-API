package com.techassess.todolistapi.service;

import com.techassess.todolistapi.dto.CreateTaskDTO;
import com.techassess.todolistapi.dto.TaskResponseDTO;
import com.techassess.todolistapi.dto.UpdateTaskDTO;
import com.techassess.todolistapi.exception.AppException;
import com.techassess.todolistapi.exception.ErrorCode;
import com.techassess.todolistapi.mapper.TaskMapper;
import com.techassess.todolistapi.model.Task;
import com.techassess.todolistapi.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }
    public List<TaskResponseDTO> getTasksByUserId(Long userId, int page, int size){
        int offset = (page - 1) * size;
        List<Task> tasks = taskMapper.getTasksByUserIdPaged(userId, size, offset);

        return tasks.stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getUserId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus().name(),
                        task.getPriority(),
                        task.getDeadline(),
                        task.getCreatedAt(),
                        task.getUpdatedAt()
                ))
                .toList();
    }

    private TaskResponseDTO mapToResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getUserId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getPriority(),
                task.getDeadline(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }


    public TaskResponseDTO addNewTask(CreateTaskDTO dto) {
        Task t = new Task();
        t.setUserId(dto.getUserId());
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setStatus(dto.getStatus() == null ? TaskStatus.PENDING : TaskStatus.valueOf(dto.getStatus()));
        t.setPriority(dto.getPriority() == null ? 3 : dto.getPriority());
        t.setDeadline(dto.getDeadline());

        taskMapper.addNewTask(t);

        // fetch full record
        Task saved = taskMapper.getTaskById(t.getId());

        return mapToResponse(saved);
    }


    public TaskResponseDTO updateTask(UpdateTaskDTO dto) {
        Task existing = taskMapper.getTaskById(dto.getId());
        if (existing == null) throw new AppException(ErrorCode.TASK_NOT_FOUND);

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setStatus(dto.getStatus() == null ? existing.getStatus() : TaskStatus.valueOf(dto.getStatus()));
        existing.setPriority(dto.getPriority() == null ? existing.getPriority() : dto.getPriority());
        existing.setDeadline(dto.getDeadline());

        taskMapper.updateTask(existing);

        Task updated = taskMapper.getTaskById(existing.getId());
        return mapToResponse(updated);
    }


    public void deleteTask(Long taskId) {
        Task t = taskMapper.getTaskById(taskId);
        if (t == null) throw new AppException(ErrorCode.TASK_NOT_FOUND);
        int rows = taskMapper.deleteTaskById(taskId);
        if (rows == 0) throw new AppException(ErrorCode.DELETE_FAILED);
    }

}
