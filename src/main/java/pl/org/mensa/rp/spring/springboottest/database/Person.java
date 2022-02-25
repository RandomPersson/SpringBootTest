package pl.org.mensa.rp.spring.springboottest.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	
	protected Person() {}
	
	public Person(String first_name, String last_name) {
		this.firstName = first_name;
		this.lastName = last_name;
	}
	
	@Override
	public String toString() {
		return Utils.buildString("ExampleTable[id=", id, ", first_name='", firstName, "', last_name='", lastName, "']");
	}
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
}
