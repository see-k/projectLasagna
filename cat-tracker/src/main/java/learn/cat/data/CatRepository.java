package learn.cat.data;

import learn.cat.models.Cat;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatRepository {
    List<Cat> findAll();

    Cat findById(int catId);

    Cat add(Cat cat);

    boolean update(Cat cat);

    @Transactional
    boolean deleteById(int catId);
}
