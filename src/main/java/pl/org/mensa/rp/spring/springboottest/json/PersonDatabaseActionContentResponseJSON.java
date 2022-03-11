package pl.org.mensa.rp.spring.springboottest.json;

import pl.org.mensa.rp.spring.springboottest.util.JSONable;

public class PersonDatabaseActionContentResponseJSON implements JSONable {
	
	private Long id;
	private String firstName;
	private String lastName;
	
	public PersonDatabaseActionContentResponseJSON(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public PersonDatabaseActionContentResponseJSON(String firstName, String lastName) {
		//TODO auto increment?
		this.id = 0L;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	/////////////
	// GETTERS //
	/////////////
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	/////////////
	// SETTERS //
	/////////////
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
