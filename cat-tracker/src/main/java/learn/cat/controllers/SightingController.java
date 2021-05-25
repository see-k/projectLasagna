package learn.cat.controllers;


import learn.cat.domain.Result;
import learn.cat.domain.SightingService;
import learn.cat.models.Sighting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/sighting")
public class SightingController {

    private final SightingService service;

    public SightingController(SightingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sighting> findAll() {
        return service.findAll();
    }

    @GetMapping("/{sightingId}")
    public Sighting findById(@PathVariable int sightingId) {
        return service.findById(sightingId);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Sighting sighting, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Result<Sighting> result = service.add(sighting);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{sightingId}")
    public ResponseEntity<Object> update(@RequestBody @Valid Sighting sighting, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Result<Sighting> result = service.update(sighting);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{sightingId}")
    public ResponseEntity<Void> deleteById(@PathVariable int sightingId) {
        if (service.deleteById(sightingId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
