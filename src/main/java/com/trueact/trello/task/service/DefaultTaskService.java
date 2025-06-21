package com.trueact.trello.task.service;

import com.trueact.trello.task.model.Task;
import com.trueact.trello.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultTaskService implements TaskService{

    private TaskRepository taskRepository;

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
}
