package ir.bigz.spring.validation.service;

import ir.bigz.spring.validation.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void addUsers(User user);

    User getUser(long userId);
}
