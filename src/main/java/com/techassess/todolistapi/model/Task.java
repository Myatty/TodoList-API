package com.techassess.todolistapi.model;

import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Setter
public class Task {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private String status;
    private Integer priority;
    private LocalDateTime deadline;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
