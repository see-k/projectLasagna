package learn.cat.data.mappers;

import learn.cat.models.Sighting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingMapper implements RowMapper<Sighting>{
    @Override
    public Sighting mapRow(ResultSet resultSet, int i) throws SQLException {
        Sighting sighting = new Sighting();
        sighting.setSightingId(resultSet.getInt("sighting_id"));
        sighting.setSightingDate(resultSet.getDate("sighting_date"));
        sighting.setSightingTime(resultSet.getTime("sighting_time"));
        sighting.setCatDescription(resultSet.getString("visual_description"));
        sighting.setSightingDescription(resultSet.getString("sighting_description"));
        sighting.setDisabled(resultSet.getBoolean("disabled"));
        sighting.setCatId(resultSet.getInt("cat_id"));
        sighting.setUsersId(resultSet.getInt("users_id"));
        sighting.setLocationId(resultSet.getInt("location_id"));
        List<String> pictures = new ArrayList<>();
        String path = resultSet.getString("img_path");
        pictures.add(path);
        sighting.setPictures(pictures);

        return sighting;
    }
}
