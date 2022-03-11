package pl.org.mensa.rp.spring.springboottest.json;

import pl.org.mensa.rp.spring.springboottest.util.JSONable;

public class PersonDatabaseActionContentJSON implements JSONable {
	
	private Long id;
	private String databaseAction;
	private String firstName;
	private String lastName;
	private String changeToFirstName;
	private String changeToLastName;
	
	public PersonDatabaseActionContentJSON(Long id, String databaseAction,
			String firstName, String lastName, String changeToFirstName, String changeToLastName) {
		this.id = id;
		this.databaseAction = databaseAction;
		this.firstName = firstName;
		this.lastName = lastName;
		this.changeToFirstName = changeToFirstName;
		this.changeToLastName = changeToLastName;
	}
	
	
	
	/////////////
	// GETTERS //
	/////////////
	
	public Long getId() {
		return id;
	}
	
	public String getDatabaseAction() {
		return databaseAction;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getChangeToFirstName() {
		return changeToFirstName;
	}
	
	public String getChangeToLastName() {
		return changeToLastName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	/////////////
	// SETTERS //
	/////////////
	
	public void setDatabaseAction(String databaseAction) {
		this.databaseAction = databaseAction;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setChangeToFirstName(String changeToFirstName) {
		this.changeToFirstName = changeToFirstName;
	}
	
	public void setChangeToLastName(String changeToLastName) {
		this.changeToLastName = changeToLastName;
	}
}
