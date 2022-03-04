package pl.org.mensa.rp.spring.springboottest.controllers;

import java.util.ArrayList;
import java.util.List;

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
			@RequestParam(value = "id", required = false, defaultValue = "0") long id,
			@RequestParam(value = "first_name", required = false, defaultValue = "") String firstName,
			@RequestParam(value = "last_name", required = false, defaultValue = "") String lastName,
			@RequestParam(value = "change_to_first_name", required = false, defaultValue = "") String changeToFirstName,
			@RequestParam(value = "change_to_last_name", required = false, defaultValue = "") String changeToLastName
		) {
		
		// here should be validation (security++) but i'm too lazy
		
		// TODO [DEBUG] remove later
		Utils.log("database_action=" + databaseAction, this.getClass());
		Utils.log("id=" + id, this.getClass());
		Utils.log("first_name=" + firstName, this.getClass());
		Utils.log("last_name=" + lastName, this.getClass());
		Utils.log("change_to_first_name=" + changeToFirstName, this.getClass());
		Utils.log("change_to_last_name=" + changeToLastName, this.getClass());
		
		ERRTYPE errorCode = ERRTYPE.NO_ERROR;
		String message;
		
		// very ugly but it's late and I'm lazy
		switch (databaseAction) {
			case "add": {
				personRepository.save(new Person(firstName, lastName));
				
				message = "Create successful";
			} break;
			
			case "remove": {
				personRepository.deleteById(id);
				
				message = "Deletion successful";
			} break;
			
			case "modify": {
				Person person = personRepository.findById(id);
				
				if (person == null) {
					errorCode = ERRTYPE.DATABASE_ID_NOT_FOUND;
					message = "Entry ID not found";
				}
				else {
					person.setFirstName(changeToFirstName);
					person.setLastName(changeToLastName);
					
					message = "Modification successful";
				}
			} break;
			
			case "list": {
				Utils.debug("'list' parameter detected", this.getClass());
				
				List<Person> result = new ArrayList<Person>();
				
				if (!firstName.isEmpty()) {
					personRepository.findByFirstName(firstName).forEach(person -> result.add(person));
					
					Utils.debug("first name not empty - showing list for '" + firstName + "'", this.getClass());
					for (Person person : result) {
						Utils.debug(person.toJSON(), this.getClass());
					}
				}
				else {
					if (!lastName.isEmpty()) {
						personRepository.findByLastName(lastName).forEach(person -> result.add(person));
						
						Utils.debug("last name not empty - showing list for '" + firstName + "'", this.getClass());
						for (Person person : result) {
							Utils.debug(person.toJSON(), this.getClass());
						}
					}
					else {
						personRepository.findAll().forEach(person -> result.add(person));
						Utils.debug("both names empty - showing list", this.getClass());
						for (Person person : result) {
							Utils.debug(person.toJSON(), this.getClass());
						}
					}
				}
				
				message = "";
				for (Person person : result) {
					message += person.toJSON() + ",";
				}
				message = "{" + message.substring(0, message.length() == 0 ? 0 : message.length()-1) + "}";
			} break;
			
			default: {
				errorCode = ERRTYPE.DATABASE_INCORRECT_DATABASE_ACTION;
				message = "Incorrect databaseAction";
			}
		}
		
		return new DatabaseActionJSON(errorCode, message);
		
	}
}
