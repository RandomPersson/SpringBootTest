package pl.org.mensa.rp.spring.springboottest.json;

import pl.org.mensa.rp.spring.springboottest.util.ERRTYPE;

public class DatabaseActionJSON {
	
	private final int id = 0;
	private final long errorCode;
	private final String message;
	
	public DatabaseActionJSON(ERRTYPE errorCode, String message) {
		this.errorCode = errorCode.getId();
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	
	public long getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
}
