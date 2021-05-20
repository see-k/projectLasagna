package learn.cat.data.mappers;

import learn.cat.models.Alias;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AliasMapper implements RowMapper<Alias> {
    @Override
    public Alias mapRow(ResultSet resultSet, int i) throws SQLException {
        Alias alias = new Alias();
        alias.setAliasId(resultSet.getInt("alias_id"));
        alias.setAliasName(resultSet.getString("alias_name"));
        alias.setCatId(resultSet.getInt("cat_id"));
        return alias;
    }
}
