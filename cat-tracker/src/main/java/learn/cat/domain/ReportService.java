package learn.cat.domain;

import learn.cat.data.ReportRepository;
import learn.cat.models.Report;
import learn.cat.models.Sighting;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class ReportService {

    private final ReportRepository repository;

    public ReportService(ReportRepository repository) { this.repository = repository; }

    public List<Report> findAll() { return repository.findAll(); }

    public Report findById(int reportId) { return repository.findById(reportId); }

    public List<Report> findByUsersId(int usersId) { return repository.findByUsersId(usersId); }

    public List<Report> findByCatId(int catId) { return repository.findByCatId(catId); }

    public Result<Report> add(Report report) {
        Result<Report> result = validate(report);
        if(!result.isSuccess()) {
            return result;
        }

        if(report.getReportId() != 0) {
            result.addMessage("ReportId cannot be set for add operation.", ResultType.INVALID);
            return result;
        }

        report = repository.add(report);
        result.setPayload(report);
        return result;
    }

    public Result<Report> update(Report report) {
        Result<Report> result = validate(report);
        if(!result.isSuccess()) {
            return result;
        }

        if(report.getReportId() <= 0) {
            result.addMessage("ReportId must be set for update operation.", ResultType.INVALID);
            return result;
        }

        if (!repository.update(report)) {
            result.addMessage(String.format("sightingId: %s was not found", report.getReportId()), ResultType.INVALID);
        }

        return result;
    }

    public boolean deleteById(int reportId) { return repository.deleteById(reportId); }

    private Result<Report> validate(Report report) {
        Result<Report> result = new Result<>();

        if (report == null) {
            result.addMessage("Report cannot be null.", ResultType.INVALID);
            return result;
        }
        //TODO validate parent exists

        //technically not needed but just in case
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Report>> violations = validator.validate(report);

        for (ConstraintViolation<Report> violation : violations) {
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }

        return result;
    }
}
