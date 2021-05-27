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
        cat.setPicture(resultSet.getString("img_path"));
        cat.setDesc(resultSet.getString("cat_description"));
        cat.setDisabled(resultSet.getBoolean("disabled"));
        cat.setUsersId(resultSet.getInt("users_id"));
        return cat;
    }
}
