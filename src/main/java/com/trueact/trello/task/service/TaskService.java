package com.trueact.trello.task.service;

import com.trueact.trello.task.model.Task;

import java.util.Optional;

public interface TaskService {
    void save (Task task);

    Optional<Task> findById(Long id);
}
