package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Chef;
import vod.repository.ChefDao;

import java.util.List;

@Repository("chefDao")
public class MemChefDao implements ChefDao {
    @Override
    public List<Chef> findAll() {
        return SampleData.chefs;
    }

    @Override
    public Chef findById(int id) {
        return SampleData.chefs.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Chef add(Chef d) {
        int max = SampleData.chefs.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.chefs.add(d);
        return d;
    }
}
