package by.innowise.by.innowise.taskService.services;

import by.innowise.by.innowise.taskService.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User findById(Long id);

    void delete(Long id);

    User update(User user, Long id);
}
