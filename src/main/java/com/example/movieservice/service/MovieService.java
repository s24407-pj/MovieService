package com.example.movieservice.service;

import com.example.movieservice.model.MovieGenre;
import com.example.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        return List.of(new Movie(1, "Titanic", MovieGenre.DRAMA, 1990, "Good movie"));
    }

    public Movie getMovieById(int id) {
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
