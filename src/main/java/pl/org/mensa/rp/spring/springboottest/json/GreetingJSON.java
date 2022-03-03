package pl.org.mensa.rp.spring.springboottest.json;

public class GreetingJSON {
	
	private final long id;
	private final String content;

	public GreetingJSON(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
