package vod.repository;

import vod.model.Restaurant;
import vod.model.Dish;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> findAll();

    Restaurant findById(int id);

    List<Restaurant> findByDish(Dish m);

}
