package by.innowise.by.innowise.taskService.factory;

import by.innowise.by.innowise.taskService.entities.Task;
import by.innowise.by.innowise.taskService.entities.dto.TaskDto;

public interface ITaskFactory {
    Task updateTask(Task task, TaskDto dto);
    Task getTask(TaskDto task);
}
