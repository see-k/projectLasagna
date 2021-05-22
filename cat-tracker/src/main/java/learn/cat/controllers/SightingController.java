package learn.cat.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/sighting")
public class SightingController {
    //(@RequestBody @Valid Sighting sighting BindingResult bindingResult)
    //if (bindingResult.hasErrors()) {
    // return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST()); }
}
