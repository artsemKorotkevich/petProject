package by.innowise.taskService.services;

import by.innowise.taskService.entities.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User findById(Long id);

    void delete(Long id);

    User update(User user, Long id);
}
