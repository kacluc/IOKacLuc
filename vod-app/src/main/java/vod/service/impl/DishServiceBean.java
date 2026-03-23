package vod.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;
import vod.repository.ChefDao;
import vod.repository.DishDao;
import vod.service.DishService;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class DishServiceBean implements DishService {

    private static final Logger log = Logger.getLogger(DishService.class.getName());

    //@Autowired
    private ChefDao chefDao;
    private PlatformTransactionManager transactionManager;
    private RestaurantDao restaurantDao;
    private DishDao dishDao;


    @Autowired
    public void setChefDao(ChefDao chefDao) {
        this.chefDao = chefDao;
    }

    public DishServiceBean(ChefDao chefDao, RestaurantDao restaurantDao, DishDao dishDao) {
        this.chefDao = chefDao;
        this.restaurantDao = restaurantDao;
        this.dishDao = dishDao;
    }

    public List<Dish> getAllDishes() {
        log.info("searching all dishes...");
        return dishDao.findAll();
    }

    public List<Dish> getDishesByChef(Chef d) {
        log.info("serching dishes by chef" + d.getId());
        return dishDao.findByChef(d);
    }

    public List<Dish> getMoviesInCinema(Restaurant c) {
        log.info("searching dishes served in restaurant " + c.getId());
        return dishDao.findByRestaurant(c);
    }

    public Dish getDishById(int id) {
        log.info("searching movie by id " + id);
        return dishDao.findById(id);
    }

    public List<Restaurant> getAllCinemas() {
        log.info("searching all cinemas");
        return restaurantDao.findAll();
    }

    public List<Restaurant> getCinemasByMovie(Dish m) {
        log.info("searching cinemas by movie " + m.getId());
        return restaurantDao.findByDish(m);
    }

    public Restaurant getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return restaurantDao.findById(id);
    }

    public List<Chef> getAllDirectors() {
        log.info("searching all directors");
        return chefDao.findAll();
    }

    public Chef getChefById(int id) {
        log.info("searching director by id " + id);
        return chefDao.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Dish addDish(Dish m) {
        log.info("about to add movie " + m);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            m = dishDao.add(m);
            if(m.getName().equals("Apokalipsa")){
                throw new RuntimeException("not yet!");
            }
        }
        catch(Exception e){
            transactionManager.rollback(ts);
            throw e;
        }
        return dishDao.add(m);
    }

    @Override
    public Chef addChef(Chef d) {
        log.info("about to add director " + d);
        return chefDao.add(d);
    }

    @Autowired
    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
