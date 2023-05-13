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

    @GetMapping("/movies/{id}")
    @ResponseBody
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else return ResponseEntity.notFound().build();
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            if (movie.getTitle() == null || movie.getGenre() == null || movie.getYear() == null) {
                return ResponseEntity.badRequest().build();
            }
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            Movie existingMovie = movieService.getMovieById(id);
            if (existingMovie == null) {
                return ResponseEntity.notFound().build();
            }
            movie.setId(id);
            movie = movieService.updateMovie(movie);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
