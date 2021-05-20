package learn.cat.data;

import learn.cat.models.Cat;

import java.util.List;

public interface CatRepository {
    List<Cat> findAll();

    Cat findById(int catId);

    Cat add(Cat cat);

    boolean update(Cat cat);

    boolean deleteById(int catId);
}
