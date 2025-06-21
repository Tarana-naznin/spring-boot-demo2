package com.trueact.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FEController {
    @GetMapping("/")
    public String home() {
        return "index.html";  // Assuming your HTML file is named `index.html`
    }
}
