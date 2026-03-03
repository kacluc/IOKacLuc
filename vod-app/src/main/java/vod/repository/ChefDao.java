package vod.repository;

import vod.model.Chef;

import java.util.List;

public interface ChefDao {

    List<Chef> findAll();

    Chef findById(int id);

    Chef add(Chef d);


}
