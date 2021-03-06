package learn.cat.data;

import learn.cat.models.Cat;
import learn.cat.models.Sighting;
import learn.cat.models.Users;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SightingRepository {
    List<Sighting> findAll();
    Sighting findById(int sightingId);
    List<Sighting> findByUsersId(int usersId);
    List<Sighting> findByCatId(int catId);
    Sighting add(Sighting sighting);
    boolean update(Sighting sighting);

    @Transactional
    boolean deleteById(int sightingId);

}
