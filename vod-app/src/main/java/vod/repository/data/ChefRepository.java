package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Chef;

public interface ChefRepository extends JpaRepository<Chef, Integer> {
}
