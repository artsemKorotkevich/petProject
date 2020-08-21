package by.innowise.taskService.services;

import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.User;
import by.innowise.taskService.entities.dto.TaskDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findByCreator(User user);
    List<Task> findAllByExecutor(User user);
    Task save(TaskDto task);
    Task update(TaskDto task);
    void delete(Long id);
    Task findById(Long id);
    Page<Task> findByUserTaskIdWithPagination (long id, int page, int size, Optional<String> status);


}
