package learn.cat.controllers;

import learn.cat.data.ReportRepository;
import learn.cat.domain.ReportService;
import learn.cat.domain.Result;
import learn.cat.models.Report;
import learn.cat.models.Sighting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) { this.service = service; }

    @GetMapping
    public List<Report> findAll() { return service.findAll(); }

    @GetMapping("/{reportId}")
    public Report findById(int reportId) { return service.findById(reportId); }

    @GetMapping("/{usersId}")
    public List<Report> findByUsersId(int usersId) { return service.findByUsersId(usersId); }

    @GetMapping("/{catId}")
    public List<Report> findByCatId(int catId) { return service.findByCatId(catId); }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Report report, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Result<Report> result = service.add(report);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{sightingId}")
    public ResponseEntity<Object> update(@RequestBody @Valid Report report, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Result<Report> result = service.update(report);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteById(@PathVariable int reportId) {
        if (service.deleteById(reportId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

