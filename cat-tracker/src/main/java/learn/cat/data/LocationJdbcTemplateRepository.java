package learn.cat.data;

import learn.cat.data.mappers.LocationMapper;
import learn.cat.models.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
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

    //TODO pending delete
    @Override
    public List<Location> findAllByCat(int catId) {
        return null;
    }

    @Override
    public Location add(Location location) {
        final String sql = "insert into location (latitude, longitude) " +
                "values(?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, location.getLatitude());
            ps.setBigDecimal(2, location.getLongitude());
            return ps;
        },keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        location.setLocationId(keyHolder.getKey().intValue());
        return location;
    }

    @Override
    public boolean update(Location location) {
        final String sql = "update location set " +
                "latitude = ?, " +
                "longitude = ? " +
                "where location_id = ?;";

        return jdbcTemplate.update(sql,
                location.getLatitude(),
                location.getLongitude(),
                location.getLocationId()) > 0;
    }

    @Override
    public boolean deleteById(int locationId) {
        return jdbcTemplate.update(
                "delete from location where location_id = ?;", locationId
        ) > 0;
    }
}
