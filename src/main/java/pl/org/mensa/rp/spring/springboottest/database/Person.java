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
	private String first_name;
	private String last_name;
	
	protected Person() {}
	
	public Person(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	@Override
	public String toString() {
		return Utils.buildString("ExampleTable[id=", id, ", first_name='", first_name, "', last_name='", last_name, "']");
	}
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
}
