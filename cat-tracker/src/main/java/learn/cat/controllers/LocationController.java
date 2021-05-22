package learn.cat.controllers;

import learn.cat.domain.LocationService;
import learn.cat.domain.Result;
import learn.cat.models.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/{locationId}")
    public Location findById(@PathVariable int locationId){
        return service.findById(locationId);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Location location, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
        return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
       }

        Result<Location> result = service.add(location);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<Object> update(@PathVariable int locationId, @RequestBody Location location) {
        if (locationId != location.getLocationId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Location> result = service.update(location);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteById(@PathVariable int locationId) {
        if (service.deleteById(locationId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
