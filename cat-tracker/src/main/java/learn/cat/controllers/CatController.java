package learn.cat.controllers;


import learn.cat.domain.CatService;
import learn.cat.domain.Result;
import learn.cat.models.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/cat")
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cat> findAll() {
        return service.findAll();
    }

    @GetMapping("/{catId}")
    public Cat findById(@PathVariable int catId) {
        return service.findById(catId);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Cat cat) {
        Result<Cat> result = service.add(cat);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<Object> update(@PathVariable @Valid int catId, @RequestBody Cat cat) {
        if (catId != cat.getCatId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Cat> result = service.update(cat);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> deleteById(@PathVariable int catId) {
        if (service.deleteById(catId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
