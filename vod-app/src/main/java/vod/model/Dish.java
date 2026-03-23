package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String poster;//url
    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;//relacja do rezysera - kolejny obiekt danych w uproszczeniu założenie że jeden film ma 1 reżysera
    private float rating;//rating
    @ManyToMany
    @JoinTable(
            name = "dish_restaurant",
            joinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    )
    private List<Restaurant> restaurants = new ArrayList<>();
//relacja wiele do wiele - bidirectional

    public Dish(int id, String name, String poster, Chef chef, float rating) {
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.chef = chef;
        this.rating = rating;
    }

    public Dish() {
    }

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @JsonIgnore
    public List<Restaurant> getCinemas() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restauracje) {
        this.restaurants = restauracje;
    }

    public void addRestaurant(Restaurant c) {
        this.restaurants.add(c);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish movie = (Dish) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Dish{" +
                "title='" + name + '\'' +
                ", chef=" + chef +
                ", rating=" + rating +
                '}';
    }
}
