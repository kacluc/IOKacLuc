package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;
import vod.web.rest.dto.DishDTO;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class DishRest {
    private final RestaurantService restaurantService;
    private final DishService dishService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/dishes")
    List<Dish> getDishes(){
        log.info("about to get all dishes");
        List<Dish> dishes = dishService.getAllDishes();
        log.info("dishes size: {}", dishes.size());
        return dishes;
    }

    @GetMapping("/dishes/{id}")
    ResponseEntity<Dish> getDish(@PathVariable("id") int id){
        log.info("about to get dish with id: {}", id);
        Dish dish = dishService.getDishById(id);
        log.info("dish: {}", dish);
        if(dish != null) {
            return ResponseEntity.ok(dish);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/restaurants/{dishId}/dishes")
    ResponseEntity<List<Dish>> getDishesServedInRestaurant(@PathVariable("dishId") int dishId){
        log.info("about to get all dishes with id: {}", dishId);
        Restaurant restaurant = restaurantService.getRestaurantById(dishId);
        if(restaurant == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Dish> dishes = restaurantService.getDishesInRestaurant(restaurant);
            log.info("dishes size: {}", dishes.size());
            return ResponseEntity.ok(dishes);
        }
    }

    @PostMapping("dishes")
    ResponseEntity<?> addDish(@RequestBody DishDTO dishDTO) {
        log.info("about to add dish: {}", dishDTO);
        Dish dish = new Dish();
        dish.setName(dishDTO.getName());
        dish.setPoster(dishDTO.getPoster());
        dish.setRating(dishDTO.getRating());
        dish.setChef(dishService.getChefById(dishDTO.getChefId()));

        dish = dishService.addDish(dish);
        log.info("dish added: {}", dish);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .path("/"+dish.getId())
                        .build()
                        .toUri())
                .body(dish);
    }
}
