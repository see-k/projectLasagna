package learn.cat.domain;

import learn.cat.data.LocationRepository;
import learn.cat.models.Location;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Location findById(int locationId) {
        return repository.findById(locationId);
    }

    //TODO add

    //TODO update

    public boolean deleteById(int locationId) {
        return repository.deleteById(locationId);
    }

    public Result<Location> validate(Location location) {
        Result<Location> result = new Result<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Location>> violations = validator.validate(location);

        for(ConstraintViolation violation : violations ){
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }
        return result;
    }
}
