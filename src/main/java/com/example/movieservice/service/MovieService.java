package com.example.movieservice.service;

import com.example.movieservice.repository.MovieRepository;
import com.example.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        List<Movie> movieArrayList = getAllMovies();
        for (Movie movie : movieArrayList){
            if(movie.getId()==id) return movie;
        }
        return null;
    }

    public Movie addMovie(Movie movie) {

        return movie;
    }

    public Movie updateMovie(Movie movie) {
        return movie;
    }
}
