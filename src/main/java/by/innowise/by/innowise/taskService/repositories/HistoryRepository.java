package by.innowise.by.innowise.taskService.repositories;

import by.innowise.by.innowise.taskService.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
