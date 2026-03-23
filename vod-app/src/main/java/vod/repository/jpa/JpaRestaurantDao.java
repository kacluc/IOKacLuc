package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.RestaurantDao;

import java.util.List;

@Repository
public class JpaRestaurantDao implements RestaurantDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurant> findAll() {
        return entityManager.createQuery("select r from Restaurant r").getResultList();
    }

    @Override
    public Restaurant findById(int id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Override
    public List<Restaurant> findByDish(Dish m) {
        return entityManager.createQuery("select r from Restaurant r inner join r.dishes dish where dish =: dish")
                .setParameter("dish", m)
                .getResultList();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        entityManager.persist(restaurant);
        return restaurant;
    }
}
