package learn.cat.data.mappers;
import learn.cat.models.Users;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements  RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException{
        Users users = new Users();
        users.setUsersId(resultSet.getInt("users_id"));
        users.setUsername(resultSet.getString("username"));
        users.setFirstName(resultSet.getString("first_name"));
        users.setLastName(resultSet.getString("last_name"));
        users.setEmail(resultSet.getString("users_email"));
        users.setDisabled(resultSet.getBoolean("disabled"));
        return users;
    }

}
