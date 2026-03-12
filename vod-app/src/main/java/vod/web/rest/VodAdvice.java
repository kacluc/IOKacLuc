package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class VodAdvice {
    private final RestaurantValidator restaurantValidator;

    @InitBinder("restaurant")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(restaurantValidator);
    }
}
