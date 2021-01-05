package ir.bigz.spring.validation.controller;

import ir.bigz.spring.validation.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class validationController {

    @PostMapping("/users")
    ResponseEntity<?> addUser(@Valid @RequestBody User user){

        return new ResponseEntity("user add success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/users")
    ResponseEntity<?> getUser(@RequestParam("userId") long id){

        return new ResponseEntity("user add success", HttpStatus.ACCEPTED);
    }
}
