package learn.cat.data;

import learn.cat.models.Report;

import java.util.List;

public interface ReportRepository {
    List<Report> findAll();
    Report findById(int reportId);
    List<Report> findByUsersId(int usersId);
    List<Report> findByCatId(int catId);
    Report add(Report report);
    boolean update(Report report);
    boolean deleteById(int reportId);
}
