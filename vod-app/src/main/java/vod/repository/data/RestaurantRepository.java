package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vod.model.Dish;
import vod.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("select r from Restaurant r inner join r.dishes dish where dish=:dish")
    List<Restaurant> findAllByDish(Dish dish);
}
