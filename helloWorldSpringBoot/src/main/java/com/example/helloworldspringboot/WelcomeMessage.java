package com.example.helloworldspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessage {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Spring Boot! My 1stServer😊";
    }
}
