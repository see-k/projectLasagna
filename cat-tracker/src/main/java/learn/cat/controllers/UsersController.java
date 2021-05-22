package learn.cat.controllers;

import learn.cat.domain.Result;
import learn.cat.domain.UsersService;
import learn.cat.models.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/users")
public class UsersController {
    
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }


    @GetMapping
    public List<Users> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/{usersId}")
    public Users findById(@PathVariable int usersId){
        return service.findById(usersId);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Users users, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Result<Users> result = service.add(users);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{usersId}")
    public ResponseEntity<Object> update(@PathVariable int usersId, @RequestBody Users users) {
        if (usersId != users.getUsersId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Users> result = service.update(users);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{usersId}")
    public ResponseEntity<Void> deleteById(@PathVariable int usersId) {
        if (service.deleteById(usersId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

