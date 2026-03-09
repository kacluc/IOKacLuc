package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class RestaurantRest {
    private final RestaurantService restaurantService;
    private final DishService dishService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants(@RequestParam(value = "phrase", required = false) String phrase,
                                    @RequestHeader(value = "custom-header", required = false) String customHeader,
                                    @CookieValue(value = "some-cookie", required = false) String someCookie
    ) {
        log.info("about to retrieve restaurants list");
        log.info("phrase: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some-cookie: {}", someCookie);
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
    ResponseEntity<?> addRestaurant(@Validated @RequestBody Restaurant restaurant, Errors errors, HttpServletRequest request) {
        log.info("adding restaurant " + restaurant);

        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe -> messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("error:\n", (accu,oe)  -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(restaurant);
        }

        restaurant = restaurantService.addRestaurant(restaurant);
        log.info("new restaruant added: ", restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }
}
