package ir.bigz.spring.validation;

import ir.bigz.spring.validation.model.User;
import ir.bigz.spring.validation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner run(UserService userService) throws Exception{

		return (String[] args) -> {
			User user1 = new User("Bob", "booo","0014713225");
			User user2 = new User("Jenny", "jooo", "0014713233");
			userService.addUsers(user1);
			userService.addUsers(user2);
		};
	}*/

}
