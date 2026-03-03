package vod.service.impl;

import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;
import vod.repository.ChefDao;
import vod.repository.DishDao;
import vod.service.DishService;

import java.util.List;
import java.util.logging.Logger;

public class DishServiceBean implements DishService {

    private static final Logger log = Logger.getLogger(DishService.class.getName());

    private ChefDao chefDao;
    private RestaurantDao restaurantDao;
    private DishDao dishDao;

    public DishServiceBean(ChefDao chefDao, RestaurantDao restaurantDao, DishDao dishDao) {
        this.chefDao = chefDao;
        this.restaurantDao = restaurantDao;
        this.dishDao = dishDao;
    }

    public List<Dish> getAllMovies() {
        log.info("searching all movies...");
        return dishDao.findAll();
    }

    public List<Dish> getMoviesByDirector(Chef d) {
        log.info("serching movies by diretor " + d.getId());
        return dishDao.findByDirector(d);
    }

    public List<Dish> getMoviesInCinema(Restaurant c) {
        log.info("searching movies played in cinema " + c.getId());
        return dishDao.findByCinema(c);
    }

    public Dish getMovieById(int id) {
        log.info("searching movie by id " + id);
        return dishDao.findById(id);
    }

    public List<Restaurant> getAllCinemas() {
        log.info("searching all cinemas");
        return restaurantDao.findAll();
    }

    public List<Restaurant> getCinemasByMovie(Dish m) {
        log.info("searching cinemas by movie " + m.getId());
        return restaurantDao.findByMovie(m);
    }

    public Restaurant getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return restaurantDao.findById(id);
    }

    public List<Chef> getAllDirectors() {
        log.info("searching all directors");
        return chefDao.findAll();
    }

    public Chef getDirectorById(int id) {
        log.info("searching director by id " + id);
        return chefDao.findById(id);
    }

    @Override
    public Dish addMovie(Dish m) {
        log.info("about to add movie " + m);
        return dishDao.add(m);
    }

    @Override
    public Chef addDirector(Chef d) {
        log.info("about to add director " + d);
        return chefDao.add(d);
    }

}
