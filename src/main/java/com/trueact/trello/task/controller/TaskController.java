package com.trueact.trello.task.controller;

import com.trueact.trello.project.model.Project;
import com.trueact.trello.task.model.Task;
import com.trueact.trello.task.repository.TaskRepository;
import com.trueact.trello.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public Void createProduct(@RequestBody Task taskDTO) {
        taskService.save(taskDTO);
        return null;
    }

    @GetMapping
    public createProduct() {
        taskService.findById();
        return null;
    }
}
