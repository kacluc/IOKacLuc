package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;

@Component
public class DummyRestaurantDao  implements RestaurantDao {
    @Override
    public List<Restaurant> findAll() {
        return List.of();
    }

    @Override
    public Restaurant findById(int id) {
        return null;
    }

    @Override
    public List<Restaurant> findByDish(Dish m) {
        return List.of();
    }
}
