package learn.cat.data;
import learn.cat.models.Location;

import java.util.List;

public interface LocationRepository {
    Location findById(int locationId);
    List<Location> findAllByCat(int catId);
    Location add(Location location);
    boolean update(Location location);
    boolean deleteById(int locationId);
}
