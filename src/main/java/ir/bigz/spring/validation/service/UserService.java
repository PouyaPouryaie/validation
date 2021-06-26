package ir.bigz.spring.validation.service;

import ir.bigz.spring.validation.dto.UserDto;
import ir.bigz.spring.validation.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void addUsers(UserDto user);

    UserDto getUser(long userId);

    UserDto getUserByName(String name);
}
