package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Chef;
import vod.repository.ChefDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataChefDao implements ChefDao {

    private final ChefRepository chefRepository;

    @Override
    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(int id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef add(Chef d) {
        return chefRepository.save(d);
    }
}
