package by.innowise.by.innowise.petProject.factory.impl;

import by.innowise.by.innowise.petProject.entities.Task;
import by.innowise.by.innowise.petProject.entities.dto.TaskDto;
import by.innowise.by.innowise.petProject.factory.ITaskFactory;
import by.innowise.by.innowise.petProject.services.UserService;
import by.innowise.by.innowise.petProject.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        task.setInspecting(userService.findById(dto.getInspecting()));
        return task;
    }

    @Override
    public Task getTask(TaskDto task) {
        return Task.builder()
                .creator(userService.findById(task.getCreator()))
                .inspecting(userService.findById(task.getInspecting()))
                .description(task.getDescription())
                .endDateTime(task.getEndDateTime())
                .executor(userService.findById(task.getExecutor()))
                .name(task.getName())
                .startDateTime(task.getStartDateTime())
                .status(task.getStatus())
                .build();
    }
}
