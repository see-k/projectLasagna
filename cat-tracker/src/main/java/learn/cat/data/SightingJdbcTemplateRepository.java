package learn.cat.data;

import learn.cat.data.mappers.SightingMapper;
import learn.cat.models.Cat;
import learn.cat.models.Sighting;
import learn.cat.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
        final String sql =
        return null;
    }

    @Override
    public List<Sighting> findByUser(Users users) {
        final String sql =
        return null;
    }

    @Override
    public List<Sighting> findByCat(Cat cat) {
        final String sql =
        return null;
    }

    @Override
    public Sighting add(Sighting sighting) {
        final String sql =
        return null;
    }

    @Override
    public boolean update(Sighting sighting) {
        final String sql = "update sighting set "
                + ""
        return false;
    }

    @Override
    public boolean deleteById(int sightingId) {
        return jdbcTemplate.update(
                "delete from sighting where sighting_id = ?;", sightingId) > 0;
    }
}
