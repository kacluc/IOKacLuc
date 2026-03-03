package vod.repository.mem;

import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;
import java.util.stream.Collectors;


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
    public List<Restaurant> findByMovie(Dish m) {
        return SampleData.restauracje.stream().filter(c -> c.getMovies().contains(m)).collect(Collectors.toList());
    }
}
