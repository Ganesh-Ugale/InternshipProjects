package com.example.Movies.dao;

import com.example.Movies.entity.Movies;

public interface MoviesDAO {
    public void saveMovies (Movies theMovie);
    public Movies fetch ();
    public void update (int byID);
    public void remove (int byID);
}
