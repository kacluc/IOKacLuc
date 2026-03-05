package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.Restaurant;
import vod.service.RestaurantService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final RestaurantService restaurantService;

    public VodComponent(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
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
    }
}
