package com.example.movieservice.controller;

import com.example.movieservice.advice.MovieValidationException;
import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies")
    @ResponseBody
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws MovieValidationException {
        if (movie.getTitle() == null || movie.getGenre() == null || movie.getYear() == null || movie.getDescription() == null) {
            throw new MovieValidationException("Missing required fields: title, genre, year, description");
        }
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movies")
    @ResponseBody
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie);
        } else return ResponseEntity.notFound().build();
    }


    @PutMapping("/movies/{id}")
    @ResponseBody
    public ResponseEntity updateMovie(@PathVariable ObjectId id, @RequestBody Movie movie) {
        try {
            Optional<Movie> theMovie = movieService.getMovieById(id);
            theMovie.ifPresent(movie1 -> movieService.updateMovie(movie));
            return ResponseEntity.ok(theMovie);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
