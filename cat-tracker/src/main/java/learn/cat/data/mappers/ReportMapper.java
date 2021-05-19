package learn.cat.data.mappers;

import learn.cat.models.Report;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapper implements RowMapper<Report> {
    @Override
    public Report mapRow(ResultSet resultSet, int i) throws SQLException {
        Report report = new Report();
        report.setReportId(resultSet.getInt("report_id"));
        report.setReportDescription(resultSet.getString("report_description"));
        report.setCatId(resultSet.getInt("cat_id"));
        report.setUsersId(resultSet.getInt("users_id"));
        report.setSightingId(resultSet.getInt("sighting_id"));
        return report;
    }
}
