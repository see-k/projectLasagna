package learn.cat.data;

import learn.cat.models.Cat;
import learn.cat.models.Sighting;
import learn.cat.models.Users;

import java.util.List;

public interface SightingRepository {
    List<Sighting> findAll();
    Sighting findById(int sightingId);
    List<Sighting> findByUser(Users users);
    List<Sighting> findByCat(Cat cat);
    Sighting add(Sighting sighting);
    boolean update(Sighting sighting);
    boolean deleteById(int sightingId);

}
