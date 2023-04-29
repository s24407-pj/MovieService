package com.example.movieservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {
    @GetMapping("/movies")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>()
    }
}
