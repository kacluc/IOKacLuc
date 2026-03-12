package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    private String logo; //url logo w przypadku UI będzie zaciągany dynamicznie
    @JsonIgnore
    private List<Dish> dishes = new ArrayList<>();//struktura kolekcyjna związaną z granymi filmami, uproszczone
//relacja wiele do wiele
    public Restaurant(int id, String name, String logo) {//konsturktor
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Restaurant() {//bezparametrowy
    }
//settery, gettery i to String - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonIgnore
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish m) {
        this.dishes.add(m);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
