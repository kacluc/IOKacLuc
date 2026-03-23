package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Chef;
import vod.model.Dish;
import vod.model.Restaurant;
import vod.repository.DishDao;

import java.util.List;

@Repository
@Primary
public class JpaDishDao implements DishDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dish> findAll() {
        return entityManager.createQuery("select d from Dish d").getResultList();
    }

    @Override
    public Dish findById(int id) {
        return entityManager.find(Dish.class, id);
    }

    @Override
    public List<Dish> findByChef(Chef d) {
        return entityManager.createQuery("select d from Dish d where d.chef = :chef")
                .setParameter("chef", d)
                .getResultList();
    }
    @Override
    public List<Dish> findByRestaurant(Restaurant c) {
        return entityManager.createQuery("select d from Dish d join d.restaurants r where r = :restaurant")
                .setParameter("restaurant", c)
                .getResultList();
    }

    @Override
    public Dish add(Dish m) {
        entityManager.persist(m);
        return m;
    }
}
