package com.example.Movies.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movies_table")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_rating")
    private float movieRating;

    @Column(name = "duration")
    private String duration;

    @Column(name = "movie_lang")
    private String movieLang;


    private Movies(){}

    public Movies(String movieName, float movieRating, String duration,
                  String movieLang) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.duration = duration;
        this.movieLang = movieLang;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", movieRating=" + movieRating +
                ", duration='" + duration + '\'' +
                ", movieLang='" + movieLang + '\'' +
                '}';
    }
}