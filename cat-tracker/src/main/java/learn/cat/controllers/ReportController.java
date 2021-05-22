package learn.cat.controllers;

import learn.cat.data.ReportRepository;
import learn.cat.domain.ReportService;
import learn.cat.models.Report;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public List<Report> findByCatId(int catId) { return service.findByCatId(catId); }

}

