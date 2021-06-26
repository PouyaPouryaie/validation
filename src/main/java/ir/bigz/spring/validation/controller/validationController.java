package ir.bigz.spring.validation.controller;

import ir.bigz.spring.validation.dto.UserDto;
import ir.bigz.spring.validation.model.User;
import ir.bigz.spring.validation.repository.UserRepository;
import ir.bigz.spring.validation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class validationController {

    private final UserService userService;

    @Autowired
    public validationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<?> addUser(@Valid @RequestBody UserDto user){
        userService.addUsers(user);
        UserDto userByName = userService.getUserByName(user.getName());
        log.debug("user save " + userByName.getId());
        return new ResponseEntity(String.format("%s add success with id: %s", userByName.getName(), userByName.getId()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/users")
    ResponseEntity<?> getUser(@RequestParam("userId") long id){
        UserDto userDto = userService.getUser(id);
        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }
}
