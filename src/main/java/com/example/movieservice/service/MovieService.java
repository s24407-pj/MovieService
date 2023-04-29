package com.example.movieservice.service;

import com.example.movieservice.model.Genre;
import com.example.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        return List.of(new Movie(1, "Titanic", Genre.DRAMA, 1990, "Good movie"));
    }
}
