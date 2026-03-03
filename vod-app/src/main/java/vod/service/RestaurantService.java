package vod.service;

import vod.model.Dish;
import vod.model.Restaurant;

import java.util.List;

public interface RestaurantService {
//api zwraca nam wszystkie kina
    Restaurant getCinemaById(int id);

    List<Restaurant> getAllCinemas();

    List<Restaurant> getCinemasByMovie(Dish m);

    List<Dish> getMoviesInCinema(Restaurant c);

}
