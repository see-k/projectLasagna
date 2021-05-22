package learn.cat.data;

import learn.cat.models.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReportJdbcTemplateRepositoryTest {

    @Autowired
    ReportJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAll() {
        List<Report> reports = repository.findAll();
        assertTrue(reports.size() >= 3 && reports.size() <= 5);
    }

    @Test
    void shouldFindById() {
        Report report = repository.findById(1);
        assertNotNull(report);
        assertEquals(3, report.getCatId());
    }

    @Test
    void shouldFindByUsersd() {
        List<Report> reports = repository.findByUsersId(1);
        assertNotNull(reports);
    }

    @Test
    void shouldFindByCatId() {
        List<Report> reports = repository.findByCatId(1);
        assertNotNull(reports);
    }

    @Test
    void shouldAdd() {
        Report report = makeReport();
        assertNotNull(repository.add(report));
        assertTrue(report.getReportId() == 4 || report.getReportId() == 3);
    }

    @Test
    void shouldUpdate() {
        Report report = makeReport();
        report.setReportId(1);
        boolean check = repository.update(report);
        assertTrue(check);
    }

    @Test
    void deleteById() {
        assertTrue(repository.deleteById(1));
    }

    private Report makeReport() {
        Report report = new Report();
        report.setReportDescription("test report");
        report.setCatId(1);
        report.setUsersId(1);
        report.setSightingId(1);
        return report;
    }
}