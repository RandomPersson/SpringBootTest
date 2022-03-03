package pl.org.mensa.rp.spring.springboottest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.org.mensa.rp.spring.springboottest.database.Person;
import pl.org.mensa.rp.spring.springboottest.database.PersonRepository;
import pl.org.mensa.rp.spring.springboottest.json.DatabaseActionJSON;
import pl.org.mensa.rp.spring.springboottest.util.ERRTYPE;
import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Controller
public class DatabaseController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DatabaseController.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/database")
	public String getDatabase() {
		return "database";
	}
	
	@PostMapping("/database/request")
	@ResponseBody
	public DatabaseActionJSON postDatabase(
			@RequestParam(value = "database_action", required = true) String databaseAction,
			@RequestParam(value = "id", required = false, defaultValue = "-1") long id,
			@RequestParam(value = "first_name", required = false, defaultValue = "") String firstName,
			@RequestParam(value = "last_name", required = false, defaultValue = "") String lastName,
			@RequestParam(value = "change_to_first_name", required = false, defaultValue = "") String changeToFirstName,
			@RequestParam(value = "change_to_last_name", required = false, defaultValue = "") String changeToLastName
		) {
		
		// validation (security)
		// but i'm too lazy
		
		Utils.log("1", logger);
		
		ERRTYPE errorCode = ERRTYPE.NO_ERROR;
		String message;
		
		// very ugly but it's late and I'm lazy
		Utils.log("2", logger);
		switch (databaseAction) {
			case "add": {
				Utils.log("2.1.1", logger);
				personRepository.save(new Person(firstName, lastName));
				Utils.log("2.1.2", logger);
				
				message = "Create successful";
			} break;
			
			case "remove": {
				Utils.log("2.2.1", logger);
				personRepository.deleteById(id);
				Utils.log("2.2.2", logger);
				
				message = "Deletion successful";
			} break;
			
			case "modify": {
				Utils.log("2.3.1", logger);
				Person person = personRepository.findById(id);
				Utils.log("2.3.2", logger);
				
				if (person == null) {
					errorCode = ERRTYPE.DATABASE_ID_NOT_FOUND;
					message = "Entry ID not found";
				}
				else {
					person.setFirstName(changeToFirstName);
					person.setLastName(changeToLastName);
					
					message = "Modification successful";
				}
				Utils.log("2.3.3", logger);
			} break;
			
			case "list": {
				Utils.log("2.4", logger);
				List<Person> result = new ArrayList<Person>();
				
				if (firstName != null) {
					personRepository.findByFirstName(firstName).forEach(person -> result.add(person));
				}
				else {
					if (lastName != null) {
						personRepository.findByLastName(lastName).forEach(person -> result.add(person));
					}
					else {
						personRepository.findAll().forEach(person -> result.add(person));
					}
				}
				
				message = " ";
				for (Person person : result) {
					message += person.toJSON() + ",";
				}
				message = "{" + message.substring(0, message.length()-1) + "}";
			} break;
			
			default: {
				errorCode = ERRTYPE.DATABASE_INCORRECT_DATABASE_ACTION;
				message = "Incorrect databaseAction";
			}
		}
		
		//TODO remove later - debug
		for (Person person : personRepository.findAll()) {
			Utils.log(person.toString(), logger);
		}
		
		return new DatabaseActionJSON(errorCode, message);
		
	}
}
