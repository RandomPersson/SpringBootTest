package pl.org.mensa.rp.spring.springboottest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.util.StringUtils;
import pl.org.mensa.rp.spring.springboottest.database.Person;
import pl.org.mensa.rp.spring.springboottest.database.PersonRepository;
import pl.org.mensa.rp.spring.springboottest.json.DatabaseActionJSON;
import pl.org.mensa.rp.spring.springboottest.util.Utils;

@RestController
public class DatabasePageController {
	
	private static final Logger logger = LoggerFactory.getLogger(DatabasePageController.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/database/")
	public String getDatabase() {
		
		return "database_page";
	}
	
	@PostMapping("/database/")
	public DatabaseActionJSON postDatabase(
			@RequestParam(value = "database_action", defaultValue = "") String database_action,
			@RequestParam(value = "first_name", defaultValue = "") String first_name,
			@RequestParam(value = "last_name", defaultValue = "") String last_name
		) {
		
		boolean success =
			StringUtils.isNotEmpty(database_action) &&
			StringUtils.isNotEmpty(first_name) &&
			StringUtils.isNotEmpty(last_name)
		;
		
		if (success) {
			personRepository.save(new Person(first_name, last_name));
		}
		
		//TODO remove later - debug
		for (Person person : personRepository.findAll()) {
			Utils.log(person.toString(), logger);
		}
		
		return new DatabaseActionJSON(success, database_action, first_name, last_name);
		
	}
}
