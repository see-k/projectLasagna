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

    public Result<Location> add(Location location){
        Result<Location> result = validate(location);
        if(!result.isSuccess()){
            return result;
        }

        if(location.getLocationId()!=0){
            result.addMessage("LocationId cannot be set for add operation", ResultType.INVALID);
            return result;
        }

        location = repository.add(location);
        result.setPayload(location);
        return result;
    }

    public Result<Location> update(Location location){
        Result<Location> result = validate(location);
        if(!result.isSuccess()){
            return result;
        }

        if(location.getLocationId() <= 0){
            result.addMessage("LocationId must be set for update operation", ResultType.INVALID);
            return result;
        }

        if(!repository.update(location)){
            String msg = String.format("LocationId: %s, not found", location.getLocationId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

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
