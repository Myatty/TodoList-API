package com.techassess.todolistapi.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTaskDTO {
    @NotNull
    private Long userId;

    @NotBlank
    private String title;

    private String description;

    // TaskService converts to TaskStatus enum
    private String status;

    private Integer priority;

    private LocalDateTime deadline;
}
