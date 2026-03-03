package vod.service;

import vod.model.Chef;
import vod.model.Dish;

import java.util.List;

public interface DishService {


    List<Dish> getAllMovies();

    List<Dish> getMoviesByDirector(Chef d);

    Dish getMovieById(int id);

    Dish addMovie(Dish m);


    List<Chef> getAllDirectors();

    Chef getDirectorById(int id);

    Chef addDirector(Chef d);
}
