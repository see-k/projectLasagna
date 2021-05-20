package learn.cat.data.mappers;

import learn.cat.models.Cat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatMapper implements RowMapper<Cat> {
    @Override
    public Cat mapRow(ResultSet resultSet, int i) throws SQLException {
        Cat cat  = new Cat();
        cat.setCatId(resultSet.getInt("cat_id"));
        cat.setName(resultSet.getString("cat_name"));
        cat.setDesc(resultSet.getString("cat_description"));
        cat.setPicture(resultSet.getString("img_path"));
        cat.setDisabled(resultSet.getBoolean("disabled"));

        UsersMapper usersMapper = new UsersMapper();
        cat.setUsers(usersMapper.mapRow(resultSet, i));
        return cat;
    }
}
