package by.innowise.by.innowise.taskService.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskEnum status;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private User creator;
    @ManyToOne
    private User executor;
    @ManyToOne
    private User inspecting;
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
    @OneToMany(mappedBy = "task")
    private List<History> historyList;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;
    @CreatedDate
    private ZonedDateTime creationDate;
    @LastModifiedDate
    private ZonedDateTime updatedDate;

}
