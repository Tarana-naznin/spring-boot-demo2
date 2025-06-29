package com.trueact.trello.task.service;

import com.trueact.trello.task.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task save (Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    void deleteById(Long id);

    Task update(Task task);
}
