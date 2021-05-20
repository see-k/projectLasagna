package learn.cat.data;

import learn.cat.data.mappers.LocationMapper;
import learn.cat.models.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationJdbcTemplateRepository implements LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocationJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Location findById(int locationId) {
        final String sql = "select location_id, latitude, longitude "
                + "from location "
                + "where location_id = ?;";
        return jdbcTemplate.query(sql, new LocationMapper(), locationId).stream()
                .findFirst()
                .orElse(null);
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
