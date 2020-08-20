package by.innowise.by.innowise.taskService.repositories;

import by.innowise.by.innowise.taskService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
    User findByEmail (String email);

}
