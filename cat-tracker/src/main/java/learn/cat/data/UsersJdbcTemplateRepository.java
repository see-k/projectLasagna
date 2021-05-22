package learn.cat.data;

import learn.cat.data.mappers.CatMapper;
import learn.cat.data.mappers.UsersMapper;
import learn.cat.models.Cat;
import learn.cat.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class UsersJdbcTemplateRepository implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Users> findAll() {
        final String sql = "select users_Id, username, first_name, last_name, users_email, disabled " +
                "from users limit 1000;";
        return jdbcTemplate.query(sql, new UsersMapper());
    }

    @Override
    public Users findById(int usersId) {
        final String sql = "select users_Id, username, first_name, last_name, users_email, disabled " +
                "from users " +
                "where users_id = ?;";
        Users users = jdbcTemplate.query(sql, new UsersMapper(), usersId).stream()
                .findFirst().orElse(null);

        return users;
    }

    @Override
    public Users add(Users users) {

        final String sql = "insert into users (username, first_name, last_name, users_email, disabled) " +
                "values (?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getFirstName());
            ps.setString(3, users.getLastName());
            ps.setString(4, users.getEmail());
            ps.setBoolean(5, users.getDisabled());
            return ps;
        }, keyHolder);

        if(rowAffected <= 0) {
            return null;
        }

        users.setUsersId(keyHolder.getKey().intValue());
        return users;
    }

    @Override
    public boolean update(Users users) {
        final String sql = "update users set " +
                "username = ?, " +
                "first_name = ?, " +
                "last_name = ?, " +
                "users_email = ?, " +
                "disabled = ? " +
                "where users_id = ?;";
        return jdbcTemplate.update(sql,
                users.getUsername(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getDisabled(),
                users.getUsersId()) > 0;
    }

    @Override
    public boolean deleteById(int usersId) {

        final String sql = "select cat_id, cat_name, img_path, cat_description, disabled, users_id " +
                "from cat " +
                "where users_id = ?;";
        Cat cat = jdbcTemplate.query(sql, new CatMapper(), usersId).stream()
                .findFirst().orElse(null);

        if (cat != null) {
            jdbcTemplate.update("delete from alias where cat_id = ?;", cat.getCatId());
            jdbcTemplate.update("delete from cat where users_id = ?;", usersId);
            jdbcTemplate.update("delete from report where users_id = ?;", usersId);
            return jdbcTemplate.update(
                    "delete from users where users_id = ?", usersId
            ) > 0;
        }

        return false;
    }
}
