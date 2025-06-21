package com.trueact.trello.project.controller;

import com.trueact.trello.project.model.Project;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @PostMapping
    public Project createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

}
