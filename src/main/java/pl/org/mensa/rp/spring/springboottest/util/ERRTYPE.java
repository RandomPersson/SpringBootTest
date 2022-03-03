package pl.org.mensa.rp.spring.springboottest.util;

public enum ERRTYPE {
	NO_ERROR(0),
	DATABASE_INCORRECT_DATABASE_ACTION(1),
	DATABASE_ID_NOT_FOUND(2);
	
	private long id;
	
	private ERRTYPE(int id) {
		this.id = id;
	}
	
	/////////////
	// GETTERS //
	/////////////
	
	public long getId() {
		return id;
	}
}
