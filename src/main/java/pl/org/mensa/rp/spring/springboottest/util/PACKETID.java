package pl.org.mensa.rp.spring.springboottest.util;

public enum PACKETID {
	BASIC_RESPONSE(0);
	
	private final long id;
	
	private PACKETID(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
