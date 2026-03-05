package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Restaurant;
import vod.service.RestaurantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantRest {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants() {
        log.info("about to retrieve restaurants list");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        log.info("{} restaurants found: ", restaurants.size());
        return restaurants;
    }
}
