package pl.org.mensa.rp.spring.springboottest.json;

public class DatabaseActionJSON {
	
	private final boolean success;
	private final String databaseAction;
	private final String firstName;
	private final String lastName;
	
	public DatabaseActionJSON(boolean success, String databaseAction, String firstName, String lastName) {
		this.success = success;
		this.databaseAction = databaseAction;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean getSuccess() {
		return success;
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
}
