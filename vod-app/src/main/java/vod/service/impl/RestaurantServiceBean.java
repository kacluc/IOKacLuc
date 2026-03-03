package vod.service.impl;

import vod.model.Restaurant;
import vod.model.Dish;
import vod.repository.RestaurantDao;
import vod.repository.DishDao;
import vod.service.RestaurantService;

import java.util.List;
import java.util.logging.Logger;

public class RestaurantServiceBean implements RestaurantService {

    private static final Logger log = Logger.getLogger(RestaurantService.class.getName());

    private RestaurantDao restaurantDao;
    private DishDao dishDao;

    public RestaurantServiceBean(RestaurantDao restaurantDao, DishDao dishDao) {
        log.info("creating cinema service bean");
        this.restaurantDao = restaurantDao;
        this.dishDao = dishDao;
    }

    @Override
    public Restaurant getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return restaurantDao.findById(id);
    }

    @Override
    public List<Dish> getMoviesInCinema(Restaurant c) {
        log.info("searching movies played in cinema " + c.getId());
        return dishDao.findByCinema(c);
    }

    @Override
    public List<Restaurant> getAllCinemas() {
        log.info("searching all cinemas");
        return restaurantDao.findAll();
    }

    @Override
    public List<Restaurant> getCinemasByMovie(Dish m) {
        log.info("searching cinemas by movie " + m.getId());
        return restaurantDao.findByMovie(m);
    }

}
