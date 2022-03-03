package pl.org.mensa.rp.spring.springboottest.json;

import pl.org.mensa.rp.spring.springboottest.util.ERRTYPE;

public class DatabaseActionJSON {
	
	private final int packetId = 2;
	private final long errorCode;
	private final String message;
	
	public DatabaseActionJSON(ERRTYPE errorCode, String message) {
		this.errorCode = errorCode.getId();
		this.message = message;
	}
	
	public int getPacketId() {
		return packetId;
	}
	
	public long getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
}
