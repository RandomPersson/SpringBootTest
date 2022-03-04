package pl.org.mensa.rp.spring.springboottest.controllers;

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
		Utils.debug("Received /database GET request:", this.getClass());
		
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
		
		Utils.debug("Received /database/request POST request:", this.getClass());
		Utils.debug("database_action=" + databaseAction, this.getClass());
		Utils.debug("id=" + id, this.getClass());
		Utils.debug("first_name=" + firstName, this.getClass());
		Utils.debug("last_name=" + lastName, this.getClass());
		Utils.debug("change_to_first_name=" + changeToFirstName, this.getClass());
		Utils.debug("change_to_last_name=" + changeToLastName, this.getClass());
		
		ERRTYPE errorCode = ERRTYPE.NO_ERROR;
		String message = "";
		
		// looks better but should be in separate class probably?
		switch (databaseAction) {
			case "add": {
				personRepository.save(new Person(firstName, lastName));
			} break;
			
			case "remove": {
				personRepository.deleteById(id);
			} break;
			
			case "modify": {
				List<Person> personList = personRepository.findByEverythingNullable(id, firstName, lastName);
				
				if (personList.size() > 1) {
					errorCode = ERRTYPE.DATABASE_RESULT_SIZE_MORE_THAN_ONE;
					break;
				}
				if (personList.size() == 0) {
					errorCode = ERRTYPE.DATABASE_ID_NOT_FOUND;
					break;
				}
				
				Person person = personList.get(0);
				person.setFirstName(changeToFirstName);
				person.setLastName(changeToLastName);
			} break;
			
			case "list": {
				List<Person> personList = personRepository.findByEverythingNullable(id, firstName, lastName);
				
				for (Person person : personList) {
					message += person.toJSON() + ",";
				}
				message = "{" + message.substring(0, message.length() == 0 ? 0 : message.length()-1) + "}";
			} break;
			
			default: {
				errorCode = ERRTYPE.DATABASE_INCORRECT_DATABASE_ACTION;
			}
		}
		
		return new DatabaseActionJSON(errorCode, message);
		
	}
}
