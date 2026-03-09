package vod.service;

import vod.model.Chef;
import vod.model.Dish;

import java.util.List;

public interface DishService {


    List<Dish> getAllDishes();

    List<Dish> getDishesByChef(Chef d);

    Dish getDishById(int id);

    Dish addDish(Dish m);


    List<Chef> getAllDirectors();

    Chef getChefById(int id);

    Chef addChef(Chef d);
}
