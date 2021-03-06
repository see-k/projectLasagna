package learn.cat.data;

import learn.cat.data.mappers.SightingMapper;
import learn.cat.models.Cat;
import learn.cat.models.Sighting;
import learn.cat.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SightingJdbcTemplateRepository implements SightingRepository {

    private final JdbcTemplate jdbcTemplate;

    public SightingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sighting> findAll() {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id "
                + "from sighting limit 1000;";
        return jdbcTemplate.query(sql, new SightingMapper());
    }

    @Override
    public Sighting findById(int sightingId) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id "
                + "from sighting "
                + "where sighting_id = ?;";

        return jdbcTemplate.query(sql, new SightingMapper(), sightingId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<Sighting> findByUsersId(int userId) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id "
                + "from sighting "
                + "where users_id = ?;";

        return new ArrayList<>(jdbcTemplate.query(sql, new SightingMapper(), userId));
    }

    @Override
    public List<Sighting> findByCatId(int catId) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id "
                + "from sighting "
                + "where cat_id = ?;";

        return new ArrayList<>(jdbcTemplate.query(sql, new SightingMapper(), catId));
    }

    @Override
    public Sighting add(Sighting sighting) {
        final String sql = "insert into sighting (img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id) "
                + "values (?,?,?,?,?,?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sighting.getPicture());
            ps.setString(2, sighting.getCatDescription());
            ps.setString(3, sighting.getSightingDescription());
            ps.setDate(4, sighting.getSightingDate());
            ps.setTime(5, sighting.getSightingTime());
            ps.setBigDecimal(6, sighting.getLatitude());
            ps.setBigDecimal(7, sighting.getLongitude());
            ps.setBoolean(8, sighting.isDisabled());
            ps.setInt(9, sighting.getUsersId());
            ps.setInt(10, sighting.getCatId());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        sighting.setSightingId(keyHolder.getKey().intValue());
        return sighting;
    }

    @Override
    public boolean update(Sighting sighting) {
        final String sql = "update sighting set "
                + "img_path = ?, "
                + "visual_description = ?, "
                + "sighting_description = ?, "
                + "sighting_date = ?, "
                + "sighting_time = ?, "
                + "latitude = ?, "
                + "longitude = ?, "
                + "disabled = ?, "
                + "users_id = ?, "
                + "cat_id = ? "
                + "where sighting_id = ?;";

        return jdbcTemplate.update(sql,
                sighting.getPicture(),
                sighting.getCatDescription(),
                sighting.getSightingDescription(),
                sighting.getSightingDate(),
                sighting.getSightingTime(),
                sighting.getLatitude(),
                sighting.getLongitude(),
                sighting.isDisabled(),
                sighting.getUsersId(),
                sighting.getCatId(),
                sighting.getSightingId()) > 0;
    }

    @Override
    @Transactional
    public boolean deleteById(int sightingId) {
        jdbcTemplate.update("delete from report where sighting_id = ?;", sightingId);
        return jdbcTemplate.update(
                "delete from sighting where sighting_id = ?;", sightingId) > 0;
    }
}

