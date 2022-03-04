package pl.org.mensa.rp.spring.springboottest.database;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.org.mensa.rp.spring.springboottest.util.JSONable;
import pl.org.mensa.rp.spring.springboottest.util.Utils;

@Entity
public class Person implements JSONable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	
	protected Person() {}
	
	public Person(long id, String firstName, String lastName) {
		this(firstName, lastName);
		this.id = id;
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/////////////
	// GETTERS //
	/////////////
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	/////////////
	// SETTERS //
	/////////////
	
//	public void setId(long id) {
//		this.id = id;
//	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	///////////////
	// OVERRIDES //
	///////////////
	
	@Override
	public String toJSON() {
		return String.format("{id:%d,first_name:%s,last_name:%s}", id, firstName, lastName);
	}
	
	@Override
	public String toString() {
		return Utils.buildString("Person[id=", id, ", first_name='", firstName, "', last_name='", lastName, "']");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Person employee = (Person) obj;
		
		return
			Objects.equals(id, employee.id) &&
			Objects.equals(firstName, employee.firstName) &&
			Objects.equals(lastName, employee.lastName)
		;
	}
}
