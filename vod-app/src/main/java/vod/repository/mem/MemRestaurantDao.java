package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("restaurantDao")
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

    @Override
    public Restaurant save(Restaurant restaurant) {
        int maxId = SampleData.restauracje.stream().sorted((c1,c2)-> c2.getId() - c1.getId())
                .findFirst()
                .map(c-> c.getId())
                .orElse(0);
        restaurant.setId(maxId+1);
        SampleData.restauracje.add(restaurant);
        return restaurant;
    }
}
