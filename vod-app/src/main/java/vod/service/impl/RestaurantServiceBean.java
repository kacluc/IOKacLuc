package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Restaurant;
import vod.model.Dish;
import vod.repository.RestaurantDao;
import vod.repository.DishDao;
import vod.service.RestaurantService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class RestaurantServiceBean implements RestaurantService {

    private static final Logger log = Logger.getLogger(RestaurantService.class.getName());

    private RestaurantDao restaurantDao;
    private DishDao dishDao;

    public RestaurantServiceBean(RestaurantDao restaurantDao, DishDao dishDao) {
        log.info("creating Restaurant service bean");
        this.restaurantDao = restaurantDao;
        this.dishDao = dishDao;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        log.info("searching cinema by id " + id);
        return restaurantDao.findById(id);
    }

    @Override
    public List<Dish> getDishesInRestaurant(Restaurant c) {
        log.info("searching dishes served in restaurant " + c.getId());
        return dishDao.findByRestaurant(c);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        log.info("adding restaurant " + restaurant);
        return restaurantDao.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        log.info("searching all restaurants");
        return restaurantDao.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByDish(Dish m) {
        log.info("searching restaurants by dish " + m.getId());
        return restaurantDao.findByDish(m);
    }

}
