package com.trueact.trello.task.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tTask")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

//    @Column(name = "issueid", updatable = false)
//    private int issueId;

    @Column(name = "priorityid", updatable = false)
    private int priorityId;

    @Column(name = "parentTaskid", updatable = false)
    private long parentTaskId;

    @Column(name = "label", updatable = false)
    private String label;

    @Column(name = "workflow", updatable = false)
    private String workflow;

    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "dueDate", updatable = false)
    private LocalDateTime dueDate;

//    @Column(name = "assigneeid", updatable = false)
//    private String assigneeId;
}
