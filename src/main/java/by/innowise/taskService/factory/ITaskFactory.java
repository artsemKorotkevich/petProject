package by.innowise.taskService.factory;

import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.dto.TaskDto;

public interface ITaskFactory {
    Task updateTask(Task task, TaskDto dto);
    Task getTask(TaskDto task);
}
