package by.innowise.taskService.repositories;

import by.innowise.taskService.config.FlywayMigrationConfig;
import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.TaskEnum;
import by.innowise.taskService.entities.User;
import by.innowise.taskService.repositories.TaskRepository;
import by.innowise.taskService.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@DataJpaTest
@ActiveProfiles("test")
@Import(FlywayMigrationConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddTask() {
        User userById = userRepository.findUserById(1);
        System.out.println(userById);
        Task task = new Task();
        task.setName("task2");
        task.setStatus(TaskEnum.IN_PROGRESS);
        task.setDescription("test test");
        task.setCreator(userById);
        task.setExecutor(userById);
        task.setStartDateTime(LocalDateTime.now());
        task.setEndDateTime(LocalDateTime.now());
        task.setCreationDate(ZonedDateTime.now());
        Task save = taskRepository.save(task);
        Assert.assertFalse(taskRepository.findById(save.getId()).isEmpty());
    }
}