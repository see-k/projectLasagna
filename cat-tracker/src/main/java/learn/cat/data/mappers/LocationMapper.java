package learn.cat.data.mappers;
import learn.cat.models.Location;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException{
        Location location = new Location();
        location.setLocationId(resultSet.getInt("location_id"));
        location.setLongitude(resultSet.getBigDecimal("longitude"));
        location.setLatitude(resultSet.getBigDecimal("latitude"));
        return location;
    }
}
