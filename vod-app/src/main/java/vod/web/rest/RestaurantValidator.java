package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Restaurant;
import vod.service.RestaurantService;

@Component
@RequiredArgsConstructor
public class RestaurantValidator implements Validator {
    private final RestaurantService restaurantService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Restaurant.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Restaurant validatedRestaurant = (Restaurant) target;

        boolean duplicated = restaurantService.getAllRestaurants().stream()
                .anyMatch(restaurant->restaurant.getName().equalsIgnoreCase(validatedRestaurant.getName()));
        if (duplicated) {
            errors.rejectValue("name", "restaurant.name.duplicated");
        }
    }
}
