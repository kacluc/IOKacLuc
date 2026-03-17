package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final DishService dishService;

    @GetMapping("/restaurants")
    String getRestaurants(Model model,
                          @RequestParam(value = "dishId", required = false) Integer dishId) {
        log.info("about to get restaurants");
        if(dishId != null) {
            Dish dish = dishService.getDishById(dishId);
            List<Restaurant> restaurants = restaurantService.getRestaurantByDish(dish);
            model.addAttribute("restaurants", restaurants);
            model.addAttribute("name", "Restaurants serving '" +  dish.getName() + "'");
        } else {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            model.addAttribute("restaurants", restaurants);
        }
        return "restaurantsView";
    }
}
