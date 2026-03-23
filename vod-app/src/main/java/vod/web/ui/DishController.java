package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.service.DishService;
import vod.service.RestaurantService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DishController {
    private final RestaurantService restaurantService;
    private final DishService dishService;

    @GetMapping("/dishes")
    String getDishes(Model model,
                     @RequestParam(value = "restaurantId", required = false) Integer restaurantId,
                     @RequestParam(value = "chefId", required = false) Integer chefId) {
        log.info("about to display dishes list in restaurant {}", restaurantId);
        if(restaurantId != null) {
            Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
            List<Dish> dishes = restaurantService.getDishesInRestaurant(restaurant);
            model.addAttribute("dishes", dishes);
            model.addAttribute("name", "Dishes in restaurant '" + restaurant.getName() + "'");
        } else if(chefId != null) {
            Chef chef = dishService.getChefById(chefId);
            List<Dish> dishes = dishService.getDishesByChef(chef);
            model.addAttribute("dishes", dishes);
            model.addAttribute("name","Dishes cooked by '" + chef.getLastName() + "'");
        } else {
            List<Dish> dishes = dishService.getAllDishes();
            model.addAttribute("dishes", dishes);
            model.addAttribute("name", "dishes");
        }
        return "dishesView";
    }
}
