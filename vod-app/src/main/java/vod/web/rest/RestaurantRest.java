package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class RestaurantRest {
    private final RestaurantService restaurantService;
    private final DishService dishService;

    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants(@RequestParam(value = "phrase", required = false) String phrase,
                                    @RequestHeader(value = "custom-header", required = false) String customHeader
                                    ) {
        log.info("about to retrieve restaurants list");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        log.info("{} restaurants found: ", restaurants.size());
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") int id) {
        log.info("about to retrieve restaurant by id {}", id);
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        log.info("{} restaurant found: ", restaurant);
        if(restaurant != null) {
            return ResponseEntity.status(200).body(restaurant);
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dish/{dishId}/restaurants")
    ResponseEntity<List<Restaurant>> getRestaurantsWithDishes(@PathVariable("dishId") int dishId) {
        log.info("about to retrieve restaurants with dish id {}", dishId);
        Dish dish = dishService.getDishById(dishId);
        if(dish == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Restaurant> restaurants = restaurantService.getRestaurantByDish(dish);
            log.info("{} restaurants found with dish {}", restaurants.size(), dish.getTitle());
            return ResponseEntity.ok(restaurants);
        }
    }

    @PostMapping("/restaurants")
    ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        log.info("adding restaurant " + restaurant);
        //TODO validation
        restaurant = restaurantService.addRestaurant(restaurant);
        log.info("new restaruant added: ", restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }
}
