package by.innowise.by.innowise.petProject.repositories;

import by.innowise.by.innowise.petProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);
    User findByEmail (String email);

}
