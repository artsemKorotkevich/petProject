package by.innowise.taskService.services.impl;

import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.TaskEnum;
import by.innowise.taskService.entities.User;
import by.innowise.taskService.entities.dto.TaskDto;
import by.innowise.taskService.factory.ITaskFactory;
import by.innowise.taskService.repositories.TaskRepository;
import by.innowise.taskService.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private ITaskFactory taskFactory;
    private TaskRepository taskRepository;

    public TaskServiceImpl(ITaskFactory taskFactory, TaskRepository taskRepository) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByCreator(User user) {
        return taskRepository.findAllByCreator(user);
    }

    @Override
    public List<Task> findAllByExecutor(User user) {
        return taskRepository.findAllByExecutor(user);
    }

    @Override
    public Task save(TaskDto task) {
        Task newTask = taskFactory.getTask(task);
        if (newTask.getEndDateTime() == null) {
            newTask.setEndDateTime(task.getStartDateTime());
        }
        newTask.setStatus(TaskEnum.IN_PROGRESS);
        newTask.setCreationDate(ZonedDateTime.now());
        return taskRepository.save(newTask);
    }

    @Override
    public Task update(TaskDto task) {
        Task currentTask = findById(task.getId());
        taskFactory.updateTask(currentTask, task);
        return taskRepository.saveAndFlush(currentTask);
    }

    public Task update(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(findById(id));

    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }


    @Override
    public Page<Task> findByUserTaskIdWithPagination(long id, int page, int size, Optional<String> status) {
        if (status.isPresent()) {
            TaskEnum taskNum = TaskEnum.valueOf(status.get().toUpperCase());
            if (size == 0) {
                return taskRepository.findAllByStatusIsAndCreatorIdOrExecutorId(taskNum, id, Pageable.unpaged());
            }
            return taskRepository.findAllByStatusIsAndCreatorIdOrExecutorId(taskNum, id, PageRequest.of(page, size));
        }
        if (size == 0) {
            return taskRepository.findAllByStatusIsNotAndCreatorIdOrExecutorId(TaskEnum.DELETED, id, Pageable.unpaged());
        }
        return taskRepository.findAllByStatusIsNotAndCreatorIdOrExecutorId(TaskEnum.DELETED, id, PageRequest.of(page, size));
    }
}
