package com.techassess.todolistapi.mapper;

import com.techassess.todolistapi.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> getTasksByUserId(@Param("userId") Long userId);
    int addNewTask(Task task);
    int updateTask(Task task);
    boolean checkTaskAvailability(Long taskId);
    int deleteTask(Long taskId);
    Task getTaskById(Long taskId);
}
