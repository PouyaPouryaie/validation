package ir.bigz.spring.validation.repository;

import ir.bigz.spring.validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);
}
