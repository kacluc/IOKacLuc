package vod.repository.mem;

import vod.model.Chef;
import vod.model.Dish;
import vod.repository.DishDao;
import vod.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class MemDishDao implements DishDao {
    @Override
    public List<Dish> findAll() {
        return SampleData.dishes;
    }

    @Override
    public Dish findById(int id) {
        return SampleData.dishes.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Dish> findByDirector(Chef d) {
       return SampleData.dishes.stream().filter(m -> m.getDirector() == d).collect(Collectors.toList());
    }

    @Override
    public List<Dish> findByCinema(Restaurant c) {
        return SampleData.dishes.stream().filter(m -> m.getCinemas().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Dish add(Dish m) {
        int max = SampleData.dishes.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.dishes.add(m);
        return m;
    }
}
