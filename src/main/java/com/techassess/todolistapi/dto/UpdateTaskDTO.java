package com.techassess.todolistapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateTaskDTO {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String title;

    private String description;

    private String status;

    private Integer priority;

    private LocalDateTime deadline;
}