package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private int id;
    private String title;
    private String poster;//url
    private Chef chef;//relacja do rezysera - kolejny obiekt danych w uproszczeniu założenie że jeden film ma 1 reżysera
    private float rating;//rating
    private List<Restaurant> restauracje = new ArrayList<>();
//relacja wiele do wiele - bidirectional

    public Dish(int id, String title, String poster, Chef chef, float rating) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Chef getDirector() {
        return chef;
    }

    public void setDirector(Chef chef) {
        this.chef = chef;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Restaurant> getCinemas() {
        return restauracje;
    }

    public void setCinemas(List<Restaurant> restauracje) {
        this.restauracje = restauracje;
    }

    public void addCinema(Restaurant c) {
        this.restauracje.add(c);
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
                "title='" + title + '\'' +
                ", chef=" + chef +
                ", rating=" + rating +
                '}';
    }
}
