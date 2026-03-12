package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final RestaurantService restaurantService;
    private final DishService dishService;

    public VodComponent(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }

    @PostConstruct
    void init() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        log.info("{} restaurants found: ", restaurants.size());
        restaurants.forEach(restaurant -> log.info("{}", restaurant));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on contextRefreshedEvent");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        log.info("{} restaurants found: ", restaurants.size());
        restaurants.forEach(restaurant -> log.info("{}", restaurant));
        List<Dish> dishes = dishService.getAllDishes();
        dishes.forEach(dish -> log.info("{}", dish));
    }
}
