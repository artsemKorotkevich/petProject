package by.innowise.taskService.repositories;

import by.innowise.taskService.entities.Task;
import by.innowise.taskService.entities.TaskEnum;
import by.innowise.taskService.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCreator(User user);

    List<Task> findAllByExecutor(User user);

    @Query("select t from Task t where t.status = :status AND (t.creator.id = :id or t.executor.id = :id ) ")
    Page<Task> findAllByStatusIsAndCreatorIdOrExecutorId(TaskEnum status, Long id, Pageable pageable);

    @Query("select t from Task t where t.creator.id = :id or t.executor.id = :id AND t.status <> 'DELETED' ")
    Page<Task> findAllByUserIdWithPaginationWithoutDeleted(Long id, Pageable pageable);

    @Query("select t from Task t where t.status <> :status AND (t.creator.id = :id or t.executor.id = :id) ")
    Page<Task> findAllByStatusIsNotAndCreatorIdOrExecutorId(TaskEnum status, Long id, Pageable pageable);

    @Query("select t from Task t where t.creator.id = :id or t.executor.id = :id")
    List<Task> findAllByUserId(Long id);

}
