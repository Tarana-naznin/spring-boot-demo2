package com.trueact.trello.task.controller;

import com.trueact.trello.task.model.Task;
import com.trueact.trello.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        System.out.println(id);
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Task> saveProduct(@RequestBody Task task) {
        Task createdTask = taskService.save(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task Task) {
        Task updatedProduct = taskService.update(Task);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteProduct(@PathVariable long id) {
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/products-by-name")
//    public List<Task> getProductsByName(@RequestParam(name ="productName") String productName) {
//        return productService.getProductsByName(productName);
//    }
}
