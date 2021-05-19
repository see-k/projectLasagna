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
        sighting.setSightingDate(resultSet.getDate("sighting_date").toLocalDate());
        sighting.setSightingTime(resultSet.getTime("sighting_time").toLocalTime());
        sighting.setCatDescription(resultSet.getString("visual_description"));
        sighting.setSightingDescription(resultSet.getString("sighting_description"));
        sighting.setDisabled(resultSet.getBoolean("disabled"));

        LocationMapper locationMapper = new LocationMapper();
        sighting.setLocation(locationMapper.mapRow(resultSet, i));

        CatMapper catMapper = new CatMapper();
        sighting.setCat(catMapper.mapRow(resultSet, i));

        UsersMapper usersMapper = new UsersMapper();
        sighting.setUsers(usersMapper.mapRow(resultSet, i));

        List<String> pictures = new ArrayList<>();
        String path = resultSet.getString("img_path");
        pictures.add(path);
        sighting.setPictures(pictures);

        return sighting;
    }
}
