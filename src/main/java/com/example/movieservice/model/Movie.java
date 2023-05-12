package com.example.movieservice.model;

public class Movie {
    private int id;
    private String title;
    private MovieGenre movieGenre;
    private Integer year;
    private String description;

    public Movie(int id, String title, MovieGenre movieGenre, Integer year, String description) {
        this.id = id;
        this.title = title;
        this.movieGenre = movieGenre;
        this.year = year;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + movieGenre +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
