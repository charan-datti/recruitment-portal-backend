package com.charan.recruitmentportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Recruitment Portal Backend is running 🚀";
    }
}
