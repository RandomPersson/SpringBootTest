package pl.org.mensa.rp.spring.springboottest.controllers.database.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.org.mensa.rp.spring.springboottest.database.person.PersonEntity;
import pl.org.mensa.rp.spring.springboottest.database.person.PersonRepository;
import pl.org.mensa.rp.spring.springboottest.json.PacketJSON;
import pl.org.mensa.rp.spring.springboottest.json.PersonDatabaseActionContentJSON;
import pl.org.mensa.rp.spring.springboottest.json.PersonDatabaseActionContentResponseJSON;
import pl.org.mensa.rp.spring.springboottest.util.ERRTYPE;
import pl.org.mensa.rp.spring.springboottest.util.PACKETID;
import pl.org.mensa.rp.spring.springboottest.util.Utils;

@RestController
public class PersonDatabaseJSONController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping(value = "/database/request"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public PacketJSON<PersonDatabaseActionContentResponseJSON> handlePostDatabaseRequest(@RequestBody PacketJSON<PersonDatabaseActionContentJSON> packet) {
		
		PersonDatabaseActionContentJSON content = packet.getContent();
		PersonDatabaseActionContentResponseJSON responseContent = null;
		
		// here should be validation (security++) but i'm too lazy
		
		Utils.debug("Received /database/request POST request:", this.getClass());
		Utils.debug("database_action=" + content.getDatabaseAction(), this.getClass());
		Utils.debug("id=" + content.getId(), this.getClass());
		Utils.debug("first_name=" + content.getFirstName(), this.getClass());
		Utils.debug("last_name=" + content.getLastName(), this.getClass());
		Utils.debug("change_to_first_name=" + content.getChangeToFirstName(), this.getClass());
		Utils.debug("change_to_last_name=" + content.getChangeToLastName(), this.getClass());
		
		ERRTYPE errorCode = ERRTYPE.NO_ERROR;
		
		// TODO split into more methods; god this is ugly
		switch (content.getDatabaseAction()) {
			case "add": {
				personRepository.save(new PersonEntity(content.getFirstName(), content.getLastName()));
				
				responseContent = null;
			} break;
			
			case "remove": {
				personRepository.deleteById(content.getId());
				
				responseContent = null;
			} break;
			
			case "modify": {
				List<PersonEntity> personList = personRepository.findByIdEqualsAndFirstNameEqualsAndLastNameEquals(
						content.getId(), content.getFirstName(), content.getLastName());
				
				if (personList.size() > 1) {
					errorCode = ERRTYPE.DATABASE_RESULT_SIZE_MORE_THAN_ONE;
					break;
				}
				if (personList.size() == 0) {
					errorCode = ERRTYPE.DATABASE_ID_NOT_FOUND;
					break;
				}
				
				PersonEntity person = personList.get(0);
				person.setFirstName(content.getChangeToFirstName());
				person.setLastName(content.getChangeToLastName());
				
				responseContent = null;
			} break;
			
			case "list": {
				List<PersonEntity> personList = personRepository.findByIdEqualsAndFirstNameEqualsAndLastNameEquals(
						content.getId(), content.getFirstName(), content.getLastName());
				
				responseContent = null;
				for (PersonEntity person : personList) {
					//TODO LOL, make a lost or something
					responseContent = new PersonDatabaseActionContentResponseJSON(0L, person.getFirstName(), person.getLastName());
				}
			} break;
			
			default: {
				errorCode = ERRTYPE.DATABASE_INCORRECT_DATABASE_ACTION;
				responseContent = null;
			}
		}
		
		//TODO "content":null = bad, "content"={} good (maybe Jackson will help parse JSONable?)
		return new PacketJSON<PersonDatabaseActionContentResponseJSON>(PACKETID.BASIC_RESPONSE, errorCode, responseContent);
	}
}
