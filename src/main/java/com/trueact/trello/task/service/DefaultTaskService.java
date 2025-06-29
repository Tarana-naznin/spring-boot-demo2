package com.trueact.trello.task.service;

import com.trueact.trello.task.model.Task;
import com.trueact.trello.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTaskService implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
    taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }
}
