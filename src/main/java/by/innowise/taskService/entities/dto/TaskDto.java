package by.innowise.taskService.entities.dto;

import by.innowise.taskService.entities.TaskEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private long id;
    private String name;
    private TaskEnum status;
    private String description;
    private long creator;
    private long executor;
    private long inspecting;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String timeZone;
}
