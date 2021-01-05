package ir.bigz.spring.validation.service;

import ir.bigz.spring.validation.model.User;
import ir.bigz.spring.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUsers(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(long userId) {
        return userRepository.getOne(userId);
    }
}
