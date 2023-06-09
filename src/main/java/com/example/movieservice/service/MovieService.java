package com.example.movieservice.service;

import com.example.movieservice.repository.MovieRepository;
import com.example.movieservice.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        movieRepository.insert(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(ObjectId id) {
        return movieRepository.findById(id);
    }


    public Movie updateMovie(Movie movie) {

        return movieRepository.save(movie);
    }

    public boolean setAvailability(ObjectId id,boolean isAvailable) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()) return false;
        else {
            Movie movie = optionalMovie.get();
            movie.setAvailable(isAvailable);
            movieRepository.save(movie);
            return true;
        }
    }
}
