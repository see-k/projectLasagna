package learn.cat.data;

import learn.cat.data.mappers.SightingMapper;
import learn.cat.models.Cat;
import learn.cat.models.Sighting;
import learn.cat.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SightingJdbcTemplateRepository implements SightingRepository {

    private JdbcTemplate jdbcTemplate;

    public SightingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sighting> findAll() {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, disabled, users_id, location_id, cat_id "
                + "from sighting limit 1000;";
        return jdbcTemplate.query(sql, new SightingMapper());
    }

    @Override
    public Sighting findById(int sightingId) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, disabled, users_id, location_id, cat_id "
                + "from sighting "
                + "where sighting_id = ?;";

        return jdbcTemplate.query(sql, new SightingMapper(), sightingId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<Sighting> findByUser(Users users) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, disabled, users_id, location_id, cat_id "
                + "from sighting "
                + "where user_id = ?;";

        return new ArrayList<>(jdbcTemplate.query(sql, new SightingMapper(), users.getUserId()));
    }

    @Override
    public List<Sighting> findByCat(Cat cat) {
        final String sql = "select sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, disabled, users_id, location_id, cat_id "
                + "from sighting "
                + "where cat_id = ?;";

        return new ArrayList<>(jdbcTemplate.query(sql, new SightingMapper(), cat.getCatId()));
    }

    @Override
    public Sighting add(Sighting sighting) {
        final String sql = "insert into sighting (img_path, visual_description, sighting_description, sighting_date, sighting_time, disabled, users_id, location_id, cat_id) "
            + "values (?,?,?,?,?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(2, sighting.getCatDescription());
            //need to fix pictures first
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
                + "disabled = ?, "
                + "users_id = ?, "
                + "location_id = ?,"
                + "cat_id = ? "
                + "where sighting_id = ?;";

        return false;
        //return jdbcTemplate.update(/*update with picture stuff :')))*/);
    }

    @Override
    public boolean deleteById(int sightingId) {
        return jdbcTemplate.update(
                "delete from sighting where sighting_id = ?;", sightingId) > 0;
    }
}
