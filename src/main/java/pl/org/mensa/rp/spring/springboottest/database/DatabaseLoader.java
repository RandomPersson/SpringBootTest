package pl.org.mensa.rp.spring.springboottest.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.org.mensa.rp.spring.springboottest.database.person.PersonEntity;
import pl.org.mensa.rp.spring.springboottest.database.person.PersonRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
	
	private final PersonRepository personRepository;
	
	@Autowired
	public DatabaseLoader(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		personRepository.save(new PersonEntity("Human", "Persson"));
		personRepository.save(new PersonEntity("Random", "Persson"));
		personRepository.save(new PersonEntity("Human", "Being"));
		personRepository.save(new PersonEntity("Random", "Dude"));
		personRepository.save(new PersonEntity("Random", "Being"));
		
//		// fetch all customers
//		logger.info("Customers found with findAll():");
//		logger.info("-------------------------------");
//		for (Person person : personRepository.findAll()) {
//			logger.info(person.toString());
//		}
//		logger.info("");
//		
//		// fetch an individual customer by ID
//		Person person = personRepository.findById(1L);
//		logger.info("Customer found with findById(1L):");
//		logger.info("--------------------------------");
//		logger.info(person.toString());
//		logger.info("");
//		
//		// fetch customers by last name
//		logger.info("Customer found with findByLastName('Persson'):");
//		logger.info("--------------------------------------------");
//		personRepository.findByLastName("Persson").forEach(persson -> {
//			logger.info(persson.toString());
//		});
//		
//		// fetch customers by first or last name
//		logger.info("Customer found with findByFirstOrLastName('Human', 'Persson'):");
//		logger.info("--------------------------------------------");
//		personRepository.findByFirstOrLastName("Human", "Persson").forEach(persson -> {
//			logger.info(persson.toString());
//		});
//		
//		logger.info("");
	}
}
