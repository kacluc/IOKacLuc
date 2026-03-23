package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.DishDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataDishDao implements DishDao {
    private final DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> findByChef(Chef d) {
        return dishRepository.findAllByChef(d);
    }

    @Override
    public List<Dish> findByRestaurant(Restaurant c) {
        return dishRepository.findAllByRestaurantsContaining(c);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Dish add(Dish m) {
        return dishRepository.save(m);
    }
}
