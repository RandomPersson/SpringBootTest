package pl.org.mensa.rp.spring.springboottest.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
	
	private final PersonRepository person_repository;
	
	@Autowired
	public DatabaseLoader(PersonRepository person_repository) {
		this.person_repository = person_repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
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
	}
}
