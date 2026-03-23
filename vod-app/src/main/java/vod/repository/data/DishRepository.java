package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
