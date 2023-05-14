package com.example.movieservice.repository;

import com.example.movieservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
    Optional<Movie> findById(Long id);
    //List<Movie>

}
