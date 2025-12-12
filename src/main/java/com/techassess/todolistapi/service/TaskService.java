package com.techassess.todolistapi.service;

import com.techassess.todolistapi.exception.AppException;
import com.techassess.todolistapi.exception.ErrorCode;
import com.techassess.todolistapi.mapper.TaskMapper;
import com.techassess.todolistapi.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }

    public List<Task> getTasksByUserId(Long userId){
        return taskMapper.getTasksByUserId(userId);
    }

    public Task addNewTask(Task task) {

        if (task.getStatus() == null)
            task.setStatus("PENDING");

        if (task.getPriority() == null)
            task.setPriority(3);

        taskMapper.addNewTask(task);

        return taskMapper.getTaskById(task.getId());
    }

    public Task updateTask(Task task){
        if (taskMapper.checkTaskAvailability(task.getId())) {
            taskMapper.updateTask(task);
            return task;
        } else {
            throw new AppException(ErrorCode.USER_ID_NOT_FOUND);
        }
    }

    public boolean deleteTask(Long taskId){
        if (taskMapper.checkTaskAvailability(taskId)) {
            int row = taskMapper.deleteTask(taskId);
            return row > 0;
        } else {
            throw new AppException(ErrorCode.TASK_NOT_FOUND);
        }
    }
}
