package pl.org.mensa.rp.spring.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import pl.org.mensa.rp.spring.springboottest.database.Person;
import pl.org.mensa.rp.spring.springboottest.database.PersonRepository;
import pl.org.mensa.rp.spring.springboottest.util.Utils;

@SpringBootApplication
public class SpringBootTestApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootTestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// init suff
			Utils.log("&aServer initialized", logger);
		};
	}
	
	@Bean
	public CommandLineRunner databaseDemo(PersonRepository person_repository) {
		return args -> {
			person_repository.save(new Person("Human", "Persson"));
			person_repository.save(new Person("Random", "Persson"));
			person_repository.save(new Person("Human", "Being"));
			
			// fetch all customers
			logger.info("Customers found with findAll():");
			logger.info("-------------------------------");
			for (Person person : person_repository.findAll()) {
				logger.info(person.toString());
			}
			logger.info("");
			
			// fetch an individual customer by ID
			Person person = person_repository.findById(1L);
			logger.info("Customer found with findById(1L):");
			logger.info("--------------------------------");
			logger.info(person.toString());
			logger.info("");
			
			// fetch customers by last name
			logger.info("Customer found with findByLastName('Persson'):");
			logger.info("--------------------------------------------");
			person_repository.findByLastName("Persson").forEach(persson -> {
				logger.info(persson.toString());
			});
			
			logger.info("");
		};
	}
	
}
