package learn.cat.controllers;

import learn.cat.domain.LocationService;
import learn.cat.models.Location;
import org.springframework.web.bind.annotation.*;

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
}
