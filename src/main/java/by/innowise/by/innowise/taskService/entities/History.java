package by.innowise.by.innowise.taskService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private User inspecting;
    @ManyToOne
    private User commentator;
    private LocalDateTime updateDate;
}
