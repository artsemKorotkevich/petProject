package by.innowise.taskService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private Task task;
    @ManyToOne
    private User  user;
    private long parentComment;
    private String comment;
    @CreatedDate
    private ZonedDateTime creationDate;
    @LastModifiedDate
    private ZonedDateTime updatedDate;
}
