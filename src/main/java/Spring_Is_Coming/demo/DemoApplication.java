package Spring_Is_Coming.demo;

import Spring_Is_Coming.demo.models.User;
import Spring_Is_Coming.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public DemoApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(userRepository.findAll().isEmpty()){
			System.out.println("No data found but we will add some now");
			userRepository.save(new User("Zebo", "Xiong - Test data"));
			userRepository.save(new User("Liwen", "Zhu - Test data"));
		}

		for(User u : userRepository.findAll()){
			System.out.println(u.getId() + "   -    " + u.getDescription()  +  " - "  +  u.getNote());
		}


	}
}