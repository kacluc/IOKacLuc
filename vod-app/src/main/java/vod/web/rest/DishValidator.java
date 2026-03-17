package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Chef;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;
import vod.service.DishService;
import vod.service.RestaurantService;
import vod.web.rest.dto.DishDTO;

@Component
@RequiredArgsConstructor
public class DishValidator implements Validator {
    private final RestaurantService restaurantService;
    private final DishService dishService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(DishDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DishDTO dish = (DishDTO) target;
        Chef chef = dishService.getChefById(dish.getChefId());
        if (chef == null) {
            errors.rejectValue("chefId", "chef id not found");
        }
    }
}
