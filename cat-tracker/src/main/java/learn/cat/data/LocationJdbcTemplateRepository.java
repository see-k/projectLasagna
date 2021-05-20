package learn.cat.data;

import learn.cat.models.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationJdbcTemplateRepository implements LocationRepository {

    @Override
    public Location findById(int locationId) {
        return null;
    }

    @Override
    public List<Location> findAllByCat(int catId) {
        return null;
    }

    @Override
    public Location add(Location location) {
        return null;
    }

    @Override
    public boolean update(Location location) {
        return false;
    }

    @Override
    public boolean deleteById(int locationId) {
        return false;
    }
}
