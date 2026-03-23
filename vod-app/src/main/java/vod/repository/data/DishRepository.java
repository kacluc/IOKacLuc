package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findAllByChef(Chef d);

    List<Dish> findAllByRestaurantsContaining(Restaurant r);
}
