package com.example.movieservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "movies")
public class Movie {
    private ObjectId id;
    private String title;
    @Field(name = "movieGenre", targetType = FieldType.STRING)
    private MovieGenre movieGenre;
    private Integer year;
    private String description;
    private boolean isAvailable = false;

    public Movie(String title, MovieGenre movieGenre, Integer year, String description) {

        this.title = title;
        this.movieGenre = movieGenre;
        this.year = year;
        this.description = description;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", movie genre=" + movieGenre +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }

    public ObjectId getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getGenre() {
        return movieGenre;
    }

    public void setGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
