package learn.cat.domain;

import learn.cat.data.LocationRepository;
import learn.cat.models.Location;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}
