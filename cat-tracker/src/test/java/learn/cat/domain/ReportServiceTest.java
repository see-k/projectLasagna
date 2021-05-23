package learn.cat.domain;

import learn.cat.data.ReportRepository;
import learn.cat.models.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReportServiceTest {

    @Autowired
    ReportService service;

    @MockBean
    ReportRepository repository;

    @Test
    void shouldFindById() {
        Report expected = makeReport();
        expected.setReportId(1);
        when(repository.findById(1)).thenReturn(expected);
        Report actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByUsersId() {
        Report report = makeReport();
        List<Report> expected = new ArrayList<>();
        expected.add(report);
        when(repository.findByUsersId(1)).thenReturn(expected);
        List<Report> actual = service.findByUsersId(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByCatId() {
        Report report = makeReport();
        List<Report> expected = new ArrayList<>();
        expected.add(report);
        when(repository.findByCatId(1)).thenReturn(expected);
        List<Report> actual = service.findByCatId(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        Report reportIn = makeReport();
        Report reportOut = makeReport();
        reportOut.setReportId(1);

        when(repository.add(reportIn)).thenReturn(reportOut);

        Result<Report> result = service.add(reportIn);
        assertEquals(ResultType.SUCCESS, result.getType());
        assertEquals(reportOut, result.getPayload());
    }

    @Test
    void shouldNotAddSetId() {
        Report reportIn = makeReport();
        reportIn.setReportId(1);
        Result<Report> result = service.add(reportIn);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldNotAddNullSighting() {
        Result<Report> result = service.add(null);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    /*@Test
    void shouldNotAddWithNonexistentParents() {
        Report reportIn = makeReport();
        reportIn.setCatId(10);
        reportIn.setUsersId(10);
        Result<Report> result = service.add(reportIn);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }*/

    @Test
    void shouldUpdate() {
        Report report = makeReport();
        report.setReportId(1);

        when(repository.update(report)).thenReturn(true);

        Result<Report> actual = service.update(report);
        assertEquals(ResultType.SUCCESS, actual.getType());
    }

    @Test
    void shouldUpdateNullId() {
        Report report = makeReport();
        Result<Report> result = service.update(report);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldNotUpdateNullSighting() {
        Result<Report> result = service.update(null);
        assertEquals(ResultType.INVALID, result.getType());
        assertNull(result.getPayload());
    }

    @Test
    void shouldDeleteById() {
        when(repository.deleteById(2)).thenReturn(true);
        assertTrue(service.deleteById(2));
    }

    @Test
    void shouldNotDeleteById() {
        when(repository.deleteById(10)).thenReturn(false);
        assertFalse(service.deleteById(10));
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