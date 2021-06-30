package ir.bigz.spring.validation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.bigz.spring.validation.dto.UserDto;
import ir.bigz.spring.validation.model.User;
import ir.bigz.spring.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUsers(UserDto userDto) {
        if(checkUserUnique(userDto.getUserName())){
            throw new IllegalArgumentException("userName is duplicated");
        }
        else{
            User user = new ObjectMapper().convertValue(userDto, User.class);
            User save = userRepository.save(user);
        }
    }

    @Override
    public UserDto getUser(long userId) {
        User user = userRepository.getOne(userId);
        return new ObjectMapper().convertValue(user, UserDto.class);
    }

    @Override
    public UserDto getUserByName(String name) {
        Optional<UserDto> userDto = userRepository
                .findByName(name)
                .map(user1 -> new ObjectMapper().convertValue(user1, UserDto.class));
        return userDto.get();
    }

    private boolean checkUserUnique(String userName){
        return userRepository.findByName(userName).isPresent();
    }

}
