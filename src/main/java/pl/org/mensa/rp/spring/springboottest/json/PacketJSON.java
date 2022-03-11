package pl.org.mensa.rp.spring.springboottest.json;

import pl.org.mensa.rp.spring.springboottest.util.ERRTYPE;
import pl.org.mensa.rp.spring.springboottest.util.JSONable;
import pl.org.mensa.rp.spring.springboottest.util.PACKETID;

public class PacketJSON<CONTENT extends JSONable> implements JSONable {
	
	private long id;
	private long errorCode;
	private CONTENT content;
	
	protected PacketJSON() {}
	
	public PacketJSON(long id, long errorCode, CONTENT content) {
		this.id = id;
		this.errorCode = errorCode;
		this.content = content;
	}
	
	public PacketJSON(PACKETID id, ERRTYPE errorCode, CONTENT content) {
		this.id = id.getId();
		this.errorCode = errorCode.getId();
		this.content = content;
	}
	
	
	
	/////////////
	// GETTERS //
	/////////////
	
	public long getId() {
		return id;
	}
	
	public long getErrorCode() {
		return errorCode;
	}
	
	public CONTENT getContent() {
		return content;
	}
	
	
	
	/////////////
	// SETTERS //
	/////////////
	
	public void setErrorCode(ERRTYPE errorCode) {
		this.errorCode = errorCode.getId();
	}
	
	public void setContent(CONTENT content) {
		this.content = content;
	}
}
