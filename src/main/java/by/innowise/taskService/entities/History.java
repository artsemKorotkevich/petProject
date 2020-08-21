package by.innowise.taskService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private Task task;
    @ManyToOne
    private User creator;
    @ManyToOne
    private User executor;
    @ManyToOne
    private User commentator;
    @CreatedDate
    private ZonedDateTime creationDate;

}
