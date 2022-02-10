package com.example.moviefacts.controller;

import com.example.moviefacts.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFactsController {
    @GetMapping("/")
    public String index() {
        return "Velkommen til movie facts.";
    }

    @GetMapping("/findall")
    public String findall() {
        MovieRepository movieRepository = new MovieRepository();
        return movieRepository.findAll();
    }
}
