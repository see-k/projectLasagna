package learn.cat.data;

import learn.cat.data.mappers.UsersMapper;
import learn.cat.models.Users;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsersJdbcTemplateRepository implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Users> findAll() {
        final String sql = "select users_Id, username, first_name, last_name, email, disabled " +
                "from users limit 1000;";
        return jdbcTemplate.query(sql, new UsersMapper());
    }

    @Override
    public Users findById(int usersId) {
        return null;
    }

    @Override
    public Users add(Users users) {
        return null;
    }

    @Override
    public boolean update(Users users) {
        return false;
    }

    @Override
    public boolean deleteById(int usersId) {
        return false;
    }
}
