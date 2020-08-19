package by.innowise.by.innowise.petProject.factory;

import by.innowise.by.innowise.petProject.entities.Task;
import by.innowise.by.innowise.petProject.entities.dto.TaskDto;

public interface ITaskFactory {
    Task updateTask(Task task, TaskDto dto);
    Task getTask(TaskDto task);
}
