package learn.cat.domain;

import learn.cat.data.ReportRepository;
import learn.cat.models.Report;
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

    //TODO add
    public Result<Report> add(Report report) {
        return null;
    }

    //TODO update
    public Result<Report> update(Report report) {
        return null;
    }

    public boolean deleteById(int reportId) { return repository.deleteById(reportId); }

    private Result<Report> validate(Report report) {
        Result<Report> result = new Result<>();

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
