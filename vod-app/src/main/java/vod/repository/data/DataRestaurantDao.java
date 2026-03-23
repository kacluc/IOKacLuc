package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataRestaurantDao implements RestaurantDao {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> findByDish(Dish m) {
        return restaurantRepository.findAllByDish(m);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
