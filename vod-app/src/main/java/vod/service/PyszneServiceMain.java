package vod.service;

import vod.repository.RestaurantDao;
import vod.repository.DishDao;
import vod.repository.mem.MemRestaurantDao;
import vod.repository.mem.MemDishDao;
import vod.model.Restaurant;
import vod.service.impl.RestaurantServiceBean;

import java.util.List;

public class PyszneServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find restauracje!");

        // service preparation przygotowanie serwisu który używa repo jednego cinemaservice
        //chcemy wyswielic lisę kin, repo dają dostęp do nich, ale z punktu widzenia apliakcji
        //powiinismy komunikowac sie przez serwis
        //serwis jest taka fasadą ponad repozytoriami - architektura wielowarstwowa
        RestaurantDao restaurantDao = new MemRestaurantDao();
        DishDao dishDao = new MemDishDao();
        //przygotowanie serwisu ma jedna impelemntacja, moze byc ich wiecej
        //ta impelemntacja potrzebuje w swoim konstruktorze dostarczyc obiekty dao
        //tu mamy znowu dwa intefejsy i trzeba sie zastanowic z których impelemntacji skorzystać
        RestaurantService service = new RestaurantServiceBean(restaurantDao, dishDao);

        // service use
        //cinemaservice ma api zwraca wsyzstkie kina
      //  tylko że ten serwis trzeba przygotowac, trzeba pozyskać tą usługe.
        List<Restaurant> restauracje = service.getAllCinemas();
        System.out.println(restauracje.size() + " restauracje found:");
        restauracje.forEach(System.out::println);
    }
}
