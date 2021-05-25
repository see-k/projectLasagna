package learn.cat.data;

import learn.cat.data.mappers.AliasMapper;
import learn.cat.data.mappers.CatMapper;
import learn.cat.models.Cat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CatJdbcTemplateRepository implements CatRepository {
    private final JdbcTemplate jdbcTemplate;

    public CatJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cat> findAll() {
        final String sql = "SELECT cat_id, cat_name, cat_description, img_path, disabled, users_id "
                + "FROM cat LIMIT 1000;";
        return jdbcTemplate.query(sql, new CatMapper());
    }

    @Override
    public Cat findById(int catId) {
        final String sql = "SELECT cat_id, cat_name, cat_description, img_path, disabled, users_id "
                + "FROM cat "
                + "WHERE cat_id = ?;";

        Cat cat = jdbcTemplate.query(sql, new CatMapper(), catId).stream()
                .findFirst().orElse(null);

        if (cat != null) {
            addAliases(cat);
        }

        return cat;
    }

    @Override
    public Cat add(Cat cat) {
        final String sql = "INSERT INTO cat (cat_name, cat_description, img_path, disabled) "
                + " VALUES (?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getDesc());
            ps.setString(3, cat.getPicture());
            ps.setBoolean(4, cat.isDisabled());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        cat.setCatId(keyHolder.getKey().intValue());
        return cat;
    }

    @Override
    public boolean update(Cat cat) {
        final String sql = "UPDATE cat SET "
                + "cat_name = ?, "
                + "cat_description = ?, "
                + "img_path = ?, "
                + "disabled = ? "
                + "WHERE cat_id = ?;";

        return jdbcTemplate.update(sql,
                cat.getName(),
                cat.getDesc(),
                cat.getPicture(),
                cat.isDisabled(),
                cat.getCatId()) > 0;
    }

    @Override
    @Transactional
    public boolean deleteById(int catId) {
        jdbcTemplate.update("DELETE FROM alias WHERE cat_id = ?;", catId);
        jdbcTemplate.update("DELETE FROM report WHERE cat_id = ?;", catId);
        jdbcTemplate.update("DELETE FROM sighting WHERE cat_id = ?;", catId);
        return jdbcTemplate.update("DELETE FROM cat where cat_id = ?;", catId) > 0;
    }

   private void addAliases(Cat cat) {
        final String sql = "SELECT alias_id, alias_name, cat_id "
                + "FROM alias "
                + "WHERE cat_id = ?;";

        var aliases = jdbcTemplate.query(sql, new AliasMapper(), cat.getCatId());
        cat.setAliases(aliases);
    }

}
