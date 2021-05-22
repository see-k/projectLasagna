package learn.cat.domain;

import learn.cat.data.SightingRepository;
import learn.cat.models.Sighting;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class SightingService {

    private final SightingRepository repository;

    public SightingService(SightingRepository repository) { this.repository = repository; }

    public List<Sighting> findAll() { return repository.findAll(); }

    public Sighting findById(int sightingId) { return repository.findById(sightingId); }

    public List<Sighting> findByUsersId(int usersId) { return repository.findByUsersId(usersId); }

    public List<Sighting> findByCatId(int catId) { return repository.findByCatId(catId); }

    public Result<Sighting> add(Sighting sighting) {//TODO
         return null;
    }

    public Result<Sighting> update(Sighting sighting) {//TODO
        return null;
    }

    public boolean deleteById(int sightingId) { return repository.deleteById(sightingId); }

    private Result<Sighting> validate(Sighting sighting) {
        Result<Sighting> result = new Result<>();

        //technically not needed but just in case
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Sighting>> violations = validator.validate(sighting);

        for (ConstraintViolation<Sighting> violation : violations) {
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }

        return result;
    }
}
