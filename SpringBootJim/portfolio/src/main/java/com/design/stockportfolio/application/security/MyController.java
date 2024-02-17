package com.design.stockportfolio.application.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the secured home page!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome, Admin!";
    }
}
