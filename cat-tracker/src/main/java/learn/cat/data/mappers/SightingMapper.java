package learn.cat.data.mappers;

import learn.cat.models.Sighting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class SightingMapper implements RowMapper<Sighting> {
    @Override
    public Sighting mapRow(ResultSet resultSet, int i) throws SQLException {
        Sighting sighting = new Sighting();
        sighting.setSightingId(resultSet.getInt("sighting_id"));
        sighting.setPicture(resultSet.getString("img_path"));
        sighting.setCatDescription(resultSet.getString("visual_description"));
        sighting.setSightingDescription(resultSet.getString("sighting_description"));
        sighting.setSightingDate(resultSet.getDate("sighting_date"));
        sighting.setSightingTime(resultSet.getTime("sighting_time"));
        sighting.setDisabled(resultSet.getBoolean("disabled"));
        sighting.setUsersId(resultSet.getInt("users_id"));
        sighting.setLocationId(resultSet.getInt("location_id"));
        sighting.setCatId(resultSet.getInt("cat_id"));
        return sighting;
    }
}
