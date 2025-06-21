package com.trueact.trello.task.controller;

import com.trueact.trello.project.model.Project;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
        @PostMapping
    public Project createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }
}
