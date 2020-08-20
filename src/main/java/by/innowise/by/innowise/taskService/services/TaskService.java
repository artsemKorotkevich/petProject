package by.innowise.by.innowise.taskService.services;

import by.innowise.by.innowise.taskService.entities.Task;
import by.innowise.by.innowise.taskService.entities.User;
import by.innowise.by.innowise.taskService.entities.dto.TaskDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<Task> findByCreator(User user);
    List<Task> findAllByExecutor(User user);
    List<Task> findAllByInspecting(User user);
    Task save(TaskDto task);
    Task update(TaskDto task);
    void delete(Long id);
    Task findById(Long id);
    Page<Task> findByUserTaskIdWithPagination (UUID id, int page, int size, Optional<String> status);


}
