package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Chef {

    private int id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private List<Dish> dishes = new ArrayList<>();//relacja 1 do wielu
//listy zeby przey przełączniu na SpringDate nie było komplikacji
//lista od seta różni się tym że są w niej powtórzenia oraz trzymamy kolejność wrzucania
    //struktury danych wazna rzecz w zachowaniu spójności danych w warstwie aplikacyjnej
    public Chef(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Chef() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDishes(Dish m) {
        this.dishes.add(m);
    }

    @Override
    public String toString() {
        return "Chef{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
