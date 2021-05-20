package learn.cat.data;

import learn.cat.models.Report;

import java.util.List;

public interface ReportRepository {
    List<Report> findAll();
    Report findById(int reportId);
    List<Report> findByUserId(int userId);
    List<Report> findByCatId(int catId);
    Report add(Report report);
    boolean update(Report report);
    boolean deleteById(int reportId);
}
