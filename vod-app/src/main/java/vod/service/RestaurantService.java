package vod.service;

import vod.model.Dish;
import vod.model.Restaurant;

import java.util.List;

public interface RestaurantService {
//api zwraca nam wszystkie kina
    Restaurant getRestaurantById(int id);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantByDish(Dish m);

    List<Dish> getDishesInRestaurant(Restaurant c);

}
