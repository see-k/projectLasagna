package learn.cat.data;

import learn.cat.data.mappers.AliasMapper;
import learn.cat.models.Alias;
import learn.cat.models.Cat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class AliasJdbcTemplateRepository implements AliasRepository {
    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Alias findById(int aliasId) {
        final String sql = "SELECT alias_id, alias_name, cat_id "
                + "FROM alias "
                + "WHERE alias_id = ?;";

        return jdbcTemplate.query(sql, new AliasMapper(), aliasId).stream()
                .findFirst().orElse(null);
    }

    @Override
    public Alias add(Alias alias) {
        final String sql = "INSERT INTO alias (alias_name, cat_id) "
                + "VALUES (?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alias.getAliasName());
            ps.setInt(2, alias.getCatId());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        alias.setAliasId(keyHolder.getKey().intValue());
        return alias;
    }

    @Override
    public boolean update(Alias alias) {
        final String sql = "UPDATE alias SET "
                + "alias_name = ? "
                + "WHERE alias_id = ?;";

        return jdbcTemplate.update(sql,
                alias.getAliasName(),
                alias.getAliasId()) > 0;
    }

    @Override
    public boolean deleteById(int aliasId) {
        return jdbcTemplate.update("DELETE FROM alias WHERE alias_id = ?;", aliasId) > 0;
    }
}
