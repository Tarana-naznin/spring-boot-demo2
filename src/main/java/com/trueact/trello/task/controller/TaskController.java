package com.trueact.trello.task.controller;

import com.trueact.trello.task.model.Task;
import com.trueact.trello.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Void createProduct(@RequestBody Task taskDTO) {
        taskService.save(taskDTO);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        System.out.println(id);
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return null;
    }
}
