package learn.cat.data;

import learn.cat.data.mappers.ReportMapper;
import learn.cat.data.mappers.SightingMapper;
import learn.cat.models.Report;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReportJdbcTemplateRepository implements ReportRepository {

    private JdbcTemplate jdbcTemplate;

    public ReportJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Report> findAll() {
        final String sql = "select report_id, report_description, cat_id, users_id, sighting_id "
                + "from report limit 1000;";
        return jdbcTemplate.query(sql, new ReportMapper());
    }

    @Override
    public Report findById(int reportId) {
        final String sql = "select report_id, report_description, cat_id, users_id, sighting_id "
                + "from report "
                + "where report_id = ?;";

        return jdbcTemplate.query(sql, new ReportMapper(), reportId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<Report> findByUserId(int userId) {
        final String sql = "select report_id, report_description, cat_id, users_id, sighting_id "
                + "from report "
                + "where user_id = ?;";
        return new ArrayList<>(jdbcTemplate.query(sql, new ReportMapper(), userId));
    }

    @Override
    public List<Report> findByCatId(int catId) {
        final String sql = "select report_id, report_description, cat_id, users_id, sighting_id "
                + "from report "
                + "where cat_id = ?;";
        return new ArrayList<>(jdbcTemplate.query(sql, new ReportMapper(), catId));
    }

    @Override
    public Report add(Report report) {
        final String sql = "insert into report (report_description, cat_id, users_id, sighting_id) "
                + "values (?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, report.getReportDescription());
            ps.setInt(2, report.getCatId());
            ps.setInt(3, report.getUsersId());
            ps.setInt(4, report.getReportId());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        report.setReportId(keyHolder.getKey().intValue());
        return report;
    }

    @Override
    public boolean update(Report report) {
        final String sql = "update report set "
                + "report_description = ?, "
                + "cat_id = ?, "
                + "users_id = ?, "
                + "sighting_id = ? "
                + "where report_id = ?;";
        return jdbcTemplate.update(sql, report.getReportDescription(), report.getCatId(), report.getUsersId(), report.getSightingId(), report.getReportId()) > 0;
    }

    @Override
    public boolean deleteById(int reportId) {
        return jdbcTemplate.update(
                "delete from report where report_id = ?;", reportId) > 0;
    }
}
