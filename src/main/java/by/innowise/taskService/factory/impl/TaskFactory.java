package by.innowise.taskService.factory.impl;

import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.dto.TaskDto;
import by.innowise.taskService.factory.ITaskFactory;
import by.innowise.taskService.services.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory implements ITaskFactory {
    private UserServiceImpl userService;

    public TaskFactory(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Task updateTask(Task task, TaskDto dto) {
        task.setStatus(dto.getStatus());
        task.setStartDateTime(dto.getStartDateTime());
        task.setEndDateTime(dto.getEndDateTime());
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setExecutor(userService.findById(dto.getExecutor()));
        task.setCreator(userService.findById(dto.getCreator()));
        return task;
    }

    @Override
    public Task getTask(TaskDto task) {
        return Task.builder()
                .creator(userService.findById(task.getCreator()))
                .description(task.getDescription())
                .endDateTime(task.getEndDateTime())
                .executor(userService.findById(task.getExecutor()))
                .name(task.getName())
                .startDateTime(task.getStartDateTime())
                .status(task.getStatus())
                .build();
    }
}
