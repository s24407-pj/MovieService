package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/movies")
    @ResponseBody
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movie);
    }
}
