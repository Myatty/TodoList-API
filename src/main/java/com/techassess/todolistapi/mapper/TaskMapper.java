package com.techassess.todolistapi.mapper;

import com.techassess.todolistapi.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> getTasksByUserId(@Param("userId") Long userId);
    List<Task> getTasksByUserIdPaged(@Param("userId") Long userId,
                                     @Param("pageSize") int pageSize,
                                     @Param("offset") int offset);
    int addNewTask(Task task);
    int updateTask(Task task);
    boolean checkTaskAvailability(Long taskId);
    int deleteTaskById(Long taskId);
    Task getTaskById(@Param("id") Long id);
}
