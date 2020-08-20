package by.innowise.by.innowise.taskService.controllers;

import by.innowise.by.innowise.taskService.entities.Task;
import by.innowise.by.innowise.taskService.entities.TaskEnum;
import by.innowise.by.innowise.taskService.entities.dto.TaskDto;
import by.innowise.by.innowise.taskService.services.impl.TaskServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class TaskController {

    private TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    private ResponseEntity<Task> addTask(@RequestBody TaskDto task){
        Task newTask = taskService.save(task);
        if(newTask != null){
            return ResponseEntity.ok().body(newTask);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/tasks")
    private ResponseEntity updateTask(@RequestBody TaskDto taskDto) {
        Task newTask = taskService.findById(taskDto.getId());
        if (newTask != null) {
            newTask = taskService.update(taskDto);
            return ResponseEntity.ok().body(newTask);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/task")
    private ResponseEntity updateTaskStatus(@RequestParam("taskId") Long taskId,
                                            @RequestParam("status") String status) {
        Task currentTask = taskService.findById(taskId);
        currentTask.setStatus(TaskEnum.valueOf(status.toUpperCase()));
        Task newTask = taskService.update(currentTask);
        return ResponseEntity.ok().body(newTask);
    }

    @DeleteMapping("/task")
    private ResponseEntity deleteTask(@RequestParam("taskId") Long taskId) {
        Task taskForDelete = taskService.findById(taskId);
        if (taskForDelete != null) {
            taskService.delete(taskId);
            return ResponseEntity.ok().body(taskForDelete);
        }
        return ResponseEntity.badRequest().body("Task with id " + taskId + " does not exist");
    }

    @GetMapping("/user/{id}/tasks")
    private ResponseEntity<Page<Task>> getAllTask(@PathVariable Long id, @RequestParam Optional<String> status, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "0") int size) {
        Page<Task> tasks = taskService.findByUserTaskIdWithPagination(id, page, size, status);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/task")
    private ResponseEntity<Task> getTaskByTaskId(@RequestParam("taskId") Long taskId) {
        Task task = taskService.findById(taskId);
        return ResponseEntity.ok().body(task);
    }
}
