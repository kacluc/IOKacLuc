package vod.repository;

import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;

import java.util.List;

public interface DishDao {

    List<Dish> findAll();

    Dish findById(int id);

    List<Dish> findByDirector(Chef d);

    List<Dish> findByCinema(Restaurant c);

    Dish add(Dish m);

}
