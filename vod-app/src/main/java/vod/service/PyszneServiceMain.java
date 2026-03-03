package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Restaurant;

import java.util.List;

public class PyszneServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find restaurants!");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        RestaurantService service = context.getBean(RestaurantService.class);
        RestaurantService service2 = context.getBean(RestaurantService.class);

        List<Restaurant> restaurants = service.getAllRestaurants();
        System.out.println(restaurants.size() + " restaurants found:");
        restaurants.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
