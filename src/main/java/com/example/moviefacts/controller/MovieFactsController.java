package com.example.moviefacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFactsController {
    @GetMapping("/")
    public String index() {
        return "Velkommen til movie facts.";
    }
}
