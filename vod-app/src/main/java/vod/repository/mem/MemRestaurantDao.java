package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;
import java.util.stream.Collectors;

@Component("restaurantDao")
@Primary
public class MemRestaurantDao implements RestaurantDao {

    @Override
    public List<Restaurant> findAll() {
        return SampleData.restauracje;
    }

    @Override
    public Restaurant findById(int id) {
        return SampleData.restauracje.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Restaurant> findByDish(Dish m) {
        return SampleData.restauracje.stream().filter(c -> c.getDishes().contains(m)).collect(Collectors.toList());
    }
}
