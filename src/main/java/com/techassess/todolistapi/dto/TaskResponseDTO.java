package com.techassess.todolistapi.dto;

import com.techassess.todolistapi.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TaskResponseDTO {

    private Long id;

    private Long userId;

    private String title;

    private String description;

    private String status;

    private Integer priority;

    private LocalDateTime deadline;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

